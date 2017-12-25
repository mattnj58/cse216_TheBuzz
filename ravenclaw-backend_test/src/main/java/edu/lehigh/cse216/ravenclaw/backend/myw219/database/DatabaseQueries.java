package edu.lehigh.cse216.ravenclaw.backend.myw219.database;

import edu.lehigh.cse216.ravenclaw.backend.myw219.model.Message;
import edu.lehigh.cse216.ravenclaw.backend.myw219.model.User;
import edu.lehigh.cse216.ravenclaw.backend.myw219.model.Vote;
import edu.lehigh.cse216.ravenclaw.backend.myw219.util.PasswordHasher;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Cohen on 3/1/17.
 */
public class DatabaseQueries {

    private Connection conn;

    public DatabaseQueries() {
        final Map<String, String> env = System.getenv();
        String ip = env.get("MYSQL_IP");
        String port = env.get("MYSQL_PORT");
        String user = env.get("MYSQL_USER");
        String pass = env.get("MYSQL_PASS");
        String db = env.get("MYSQL_DB");

        // Connect to the database; fail if we can't
        System.out.println("Connecting to " + ip + ":" + port + "/" + db);
        try {
            // Open a connection, fail if we cannot get one
            conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" +
                    port + "/" + db, user, pass);
            if (conn == null) {
                System.out.println("Error: getConnection returned null object");
                return;
            }

        } catch (SQLException e) {
            System.out.println("Error: getConnection threw an exception");
            e.printStackTrace();
            return;
        }
    }

    public boolean authenticateUser(String username, String inputPassword) throws InvalidKeySpecException, NoSuchAlgorithmException {
        User user = getUserByUserName(username);

        if (user != null) {
            byte[] salt = user.getSalt();
            final String hashedPassword = PasswordHasher.generateStrongPasswordHash(inputPassword, salt);
            if (user.getPassword().equals(hashedPassword)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public User getUserByUserName(String username) {
        try{

            String sql = "" +
                    "SELECT user_id, username, realname, email, password, salt " +
                    "FROM user " +
                    "WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            stmt.close();

            final User user = new User();
            //gets the items from the results, coverts it to JSON, and returns it

            user.setUserId(rs.getLong("user_id"));
            user.setUsername(rs.getString("username"));
            user.setRealname(rs.getString("realname"));
            user.setEmail(rs.getString("email"));
            user.setSalt(rs.getBytes("salt"));
            user.setPassword(rs.getString("password"));

            return user;

        } catch (SQLException e) {
            System.out.println("Error: query failed");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * GET route that gets the entire message
     * gets the title and the body
     * @return
     */
    public Message getMessageByID(final Long messageId){
        try{
            Message message = new Message();
            String sql = "" +
                    "SELECT message_id, user_id, title, body, " +
                    "       (SELECT COUNT(like_id) FROM message_likes ml WHERE ml.message_id = m.message_id) as likes, " +
                    "       (SELECT COUNT(dislike_id) FROM message_dislikes md WHERE md.message_id = m.message_id) as dislikes" +
                    "FROM message m " +
                    "WHERE message_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, messageId);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                //gets the items from the results, coverts it to JSON, and returns it
                message.setMessageId(rs.getLong("message_id"));
                message.setUserId(rs.getLong("user_id"));
                message.setTitle(rs.getString("title"));
                message.setBody(rs.getString("body"));

                // Calculate total likes
                Integer likes = rs.getInt("likes");
                Integer dislikes = rs.getInt("dislikes");
                message.setLikes(likes - dislikes);
            }
            stmt.close();
            return message;

        } catch (SQLException e) {
            System.out.println("Error: query failed");
            e.printStackTrace();
            return null;
        }
    }

    public List<Message> getMessages(){
        List<Message> messages = new ArrayList<Message>();
        try{

            String sql = "" +
                    "SELECT message_id, user_id, title, body," +
                    "       (SELECT COUNT(like_id) FROM message_likes ml WHERE ml.message_id = m.message_id) as likes, " +
                    "       (SELECT COUNT(dislike_id) FROM message_dislikes md WHERE md.message_id = m.message_id) as dislikes " +
                    "FROM message m";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Message message = new Message();
                message.setMessageId(rs.getLong("message_id"));
                message.setUserId(rs.getLong("user_id"));
                message.setTitle(rs.getString("title"));
                message.setBody(rs.getString("body"));

                // Calculate total likes
                Integer likes = rs.getInt("likes");
                Integer dislikes = rs.getInt("dislikes");
                message.setLikes(likes - dislikes);

                messages.add(message);
            }

            stmt.close();
            return messages;

        } catch (SQLException e) {
            System.out.println("Error: query failed");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Creates the POST route when the user inputs all the necessary data
     */
    public Long createMessage(Message message) {
        try {
            System.out.print("Creating a post \n");
            ArrayList<String> title = new ArrayList<>();
            ArrayList<String> body = new ArrayList<>();

            String sql = "" +
                    "INSERT INTO message " +
                    " (user_id, title, body) " +
                    "VALUES " +
                    " (?, ?, ?) ";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, message.getUserId());
            stmt.setString(2, message.getTitle());
            stmt.setString(3, message.getBody());

            // Execute update
            stmt.executeUpdate();

            // Get the autogenerate message id
            ResultSet rs = stmt.executeQuery("SELECT max(message_id) FROM message");
            final Long messageId = rs.getLong("message_id");

            stmt.close();

            return messageId;
        } catch (SQLException e) {
            System.out.println("Error: insertion failed after attempts");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Updates a choosen post with a 'like' using the PUT route
     * @param vote
     */
    public void like(Vote vote) {
        System.out.print("Increasing the like of the respective vote");
        try{
            String sql = "" +
                    " INSERT INTO message_likes " +
                    " (message_id, user_id) " +
                    " VALUES " +
                    " (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, vote.getMessageId());
            stmt.setLong(2, vote.getUserId());

            stmt.executeUpdate();
            stmt.close();
            System.out.print("Liked " + vote.getMessageId());
        } catch (SQLException e) {
            System.out.println("Error: unable to like the post");
            e.printStackTrace();
        }
    }

    /**
     * updates a post with a 'dislike' a post using the PUT route
     * @param vote
     */
    public void dislike(Vote vote) {
        System.out.print("Increasing the like of the respective vote");
        try{
            String sql = "" +
                    " INSERT INTO message_dislikes " +
                    " (message_id, user_id) " +
                    " VALUES " +
                    " (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, vote.getMessageId());
            stmt.setLong(2, vote.getUserId());

            stmt.executeUpdate();
            stmt.close();
            System.out.print("Liked " + vote.getMessageId());
        } catch (SQLException e) {
            System.out.println("Error: unable to like the post");
            e.printStackTrace();
        }
    }
}