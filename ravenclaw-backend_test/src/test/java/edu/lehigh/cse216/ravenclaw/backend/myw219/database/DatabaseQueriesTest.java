package edu.lehigh.cse216.ravenclaw.backend.myw219.database;

import edu.lehigh.cse216.ravenclaw.backend.myw219.model.Message;
import edu.lehigh.cse216.ravenclaw.backend.myw219.model.User;
import edu.lehigh.cse216.ravenclaw.backend.myw219.model.Vote;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.List;

/**
 * Created by derekhuber on 3/9/17.
 */
public class DatabaseQueriesTest extends TestCase {
    public DatabaseQueriesTest(){

    }

    public void testMessages(){
        DatabaseQueries d = new DatabaseQueries();
        Message mess = new Message();
        d.createMessage(mess);
        Long messageId = new Long(12345);
        mess.setMessageId(messageId);
        assertTrue(d.getMessageByID(messageId).equals(messageId));
        List<Message> messages= d.getMessages();
        Message m = messages.get(0);
        assertTrue(m.getMessageId().equals(messageId));

    }

    public void testUsers(){
        DatabaseQueries d = new DatabaseQueries();
        User use = new User();
        use.setUsername("testUser");
        use.setPassword("testPass");
        try {
            d.authenticateUser(use.getUsername(), use.getPassword());
        }catch(Exception e){
            e.printStackTrace();
        }
        assertTrue(d.getUserByUserName("testUser").equals(use));
    }

    public void testLikeAndDislike(){
        DatabaseQueries d = new DatabaseQueries();
        Vote v = new Vote();
        d.like(v);
        assertTrue(v.isUpVote());
        d.dislike(v);
        assertTrue(!v.isUpVote());
    }


}
