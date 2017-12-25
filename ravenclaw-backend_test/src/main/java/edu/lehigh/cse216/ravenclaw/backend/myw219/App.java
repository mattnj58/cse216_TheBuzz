package edu.lehigh.cse216.ravenclaw.backend.myw219;

import com.google.gson.Gson;
import edu.lehigh.cse216.ravenclaw.backend.myw219.database.DatabaseQueries;
import edu.lehigh.cse216.ravenclaw.backend.myw219.model.Message;
import edu.lehigh.cse216.ravenclaw.backend.myw219.model.Vote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static spark.Spark.*;

/**
 * Creates the database routes and other stuff for theBuzz
 * According to
 */
public class App {

    // JSON parser. used to convert JSON to gson for the database to read
    private static Gson gson = new Gson();
    private static Map<String, String> loginTable = new HashMap<>();
    private static DatabaseQueries database = new DatabaseQueries();

    public App() {}

    public static void main(String[] args) {
        final App app = new App();

        //Sets up the file service
        staticFileLocation("/web");

        //GET '/' returns the index page needs to return
        get("/", (req, res) -> {
            res.redirect("/index.html");
            return "";
        });

        //posts a new posts into the theBuzz
        post("/login", (req, res) -> {
            final String username = req.params("username");
            final String password = req.params("password");

            if (username != null && password != null) {
                String token = null;

                // Hash password for comparison

                boolean authenticated = database.authenticateUser(username, password);
                if (authenticated) {
                    // Random token generated
                    token = UUID.randomUUID().toString();

                    // Check for token collisions and generate a
                    // new token if collisions are found
                    while (loginTable.containsKey(token)) {
                        token = UUID.randomUUID().toString();
                    }

                    // Only one login session allowed
                    if (!loginTable.containsValue(username)) {
                        loginTable.put(token, username);
                    } else {
                        // Remove old token:username pairing
                        for (String key : loginTable.keySet()) {
                            final String currentUserName = loginTable.get(key);
                            if (currentUserName.equals(username)) {
                                loginTable.remove(key);
                                break;
                            }
                        }

                        // Put new one in
                        loginTable.put(token, username);
                    }

                }

                res.status(200);
                res.type("application/json");
                return gson.toJson(token);
            } else {
                res.status(200);
                res.type("application/json");
                return "No username/password supplied";
            }
        });

        //this get/ returns a JSON string with all of the data in the theBuzz
        get("GET/messages", (req, res) -> {
            // Authenticate the token to make sure the user is logged in
            // before making requests
            String token = req.params("token");

            if (authenticateToken(token)) {
                // Get all messages from the database
                List<Message> messages = database.getMessages();

                // Sends a JSON object representing the messages
                res.status(200);
                res.type("application/json");
                return gson.toJson(messages);
            }

            return "Invalid token.";
        });


        get("GET/message/id", (req, res) -> {
            // Authenticate the token to make sure the user is logged in
            // before making requests
            String token = req.params("token");

            if (authenticateToken(token)) {

                // Pull message ID from params
                Long messageId = Long.parseLong(req.params("messageId"));
                Message message = database.getMessageByID(messageId);
                res.status(200);
                res.type("application/json");

                // Return the message as a JSON object
                return gson.toJson(message);
            }

            return "Invalid token.";
        });

        //posts a new posts into the theBuzz
        post("/createMessage", (req, res) -> {
            // Authenticate the token to make sure the user is logged in
            // before making requests
            String token = req.params("token");

            if (authenticateToken(token)) {

                // Pull message data from request body
                Message message = gson.fromJson(req.body(), Message.class);

                // Create the message
                Long messageId = database.createMessage(message);

                // Retrieve the newly created message
                message = database.getMessageByID(messageId);
                res.status(200);
                res.type("application/json");

                // Return the new message to the client as JSON
                return gson.toJson(message);
            }

            return "Invalid token.";

        });

        post("/PUT/message/id/up", (req, res) -> {
            // Authenticate the token to make sure the user is logged in
            // before making requests
            String token = req.params("token");

            if (authenticateToken(token)) {
                Vote vote = gson.fromJson(req.body(), Vote.class);
                //updates the post with a like
                database.like(vote);

                // Gets updated message and returns it to the client
                Message message = database.getMessageByID(vote.getMessageId());
                res.status(200);
                res.type("application/json");

                return gson.toJson(message);
            }

            return "Invalid token.";
        });

        post("/PUT/message/id/up", (req, res) -> {
            // Authenticate the token to make sure the user is logged in
            // before making requests
            String token = req.params("token");

            if (authenticateToken(token)) {
                Vote vote = gson.fromJson(req.body(), Vote.class);

                //updates the post with a dislike
                database.like(vote);

                // Gets updated message and returns it to the client
                Message message = database.getMessageByID(vote.getMessageId());
                res.status(200);
                res.type("application/json");

                return gson.toJson(message);
            }

            return "Invalid token.";
        });
    }

    private static boolean authenticateToken(String token) {
        return loginTable.containsKey(token);
    }


}