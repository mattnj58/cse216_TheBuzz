package edu.lehigh.cse216.ravenclaw.backend.myw219;

import edu.lehigh.cse216.ravenclaw.backend.myw219.App;
import edu.lehigh.cse216.ravenclaw.backend.myw219.model.Message;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(AppTest.class );
    }

    /**
     * Messages must have all data
     */
    public void testAllNullValues() {
        App a = new App();

        // Fetch all the messages in the db
        String initialMessages = a.getAllMessages();

        // Create message with no values
        Message message = new Message();

        // Attempt to insert message in the db; this should fail
        a.createPost(message, 0);

        // Re-fetch all the messages in the db
        String finalData = a.getAllMessages();

        // Verify that the messages in the db stayed the same, since none should
        // have been inserted
        assertTrue(initialData.equals(finalData));
    }

    /**
     * Messages must have a title
     */
    public void testNullTitle() {
        App a = new App();

        // Fetch all the messages in the db
        String initialMessages = a.getAllMessages();

        // Create message with no title
        Message message = new Message();
        message.setBody("TestMessage");
        message.setLikes(5);
        message.setCreatedDate(new Date());

        // Attempt to insert message in the db; this should fail
        a.createPost(message, 0);

        // Re-fetch all the messages in the db
        String finalData = a.getAllMessages();

        // Verify that the messages in the db stayed the same, since none should
        // have been inserted
        assertTrue(initialMessages.equals(finalData));
    }


    /**
     * Messages must contain a message
     */
    public void testNullBody(){
        App a = new App();

        // Fetch all the messages in the db
        String initialMessages = a.getAllMessages();

        // Create a message with no body
        Message message = new Message();
        message.setTitle("TestTitle");
        message.setLikes(5);
        message.setCreatedDate(new Date());

        // Attempt to insert message in the db; this should fail
        a.createPost(message, 0);

        // Re-fetch all the messages in the db
        String finalData = a.getAllMessages();

        // Verify that the messages in the db stayed the same, since none should
        // have been inserted
        assertTrue(initialMessages.equals(finalData));
    }

    /**
     * Messages must have a created date
     */
    public void testNullCreatedDate(){
        App a = new App();

        // Fetch all the messages in the db
        String initialMessages = a.getAllMessages();

        // Create a message with no created date
        Message message = new Message();
        message.setTitle("TestTitle");
        message.setBody("TestMessage");
        message.setLikes(5);

        // Re-fetch all the messages in the db
        String finalData = a.getAllMessages();

        // Verify that the messages in the db stayed the same, since none should
        // have been inserted
        assertTrue(initialMessages.equals(finalData));
    }

    /**
     * Test message creation
     */
    public void testMessageCreation(){
        // Fetch all the messages in the db
        String initialMessages = a.getAllMessages();

        // Create a new message
        Message newMessage = new Message();
        newMessage.setTitle("TestTitle");
        newMessage.setBody("TestMessage");
        newMessage.setLikes(5);                       // Set the new messages likes to 5
        final Date createdDate = new Date();
        newMessage.setCreatedDate(createdDate);

        Long ID = a.createPost(newMessage, 1);  // This method should return the primary key for the
        // newly created row.

        // Get the newly created message
        Message message = a.getMessageByID(ID);
        assertTrue(message != null);

        // Re-fetch all the messages in the db
        String finalData = a.getAllMessages();

        // Verify that the messages in the db is different, since a message should
        // have been inserted
        assertTrue(!initialMessages.equals(finalData));

        a.removeMessageByID(ID);
    }

    /**
     * Test message creation
     */
    public void testMessageRemoval() {
        // Fetch all the messages in the db
        String initialMessages = a.getAllMessages();

        // Create a new message
        Message newMessage = new Message();
        newMessage.setTitle("TestTitle");
        newMessage.setBody("TestMessage");
        newMessage.setLikes(5);                 // Set the new messages likes to 5
        final Date createdDate = new Date();
        newMessage.setCreatedDate(createdDate);

        Long ID = a.createPost(newMessage, 1);  // This method should return the primary key for the
        // newly created row.

        // Get the newly created message
        Message message = a.getMessageByID(ID);
        assertTrue(message != null);

        a.removeMessageByID(ID); // Delete the message

        // Re-fetch all the messages in the db
        String finalData = a.getAllMessages();

        // Verify that the messages in the db stayed the same, since the
        // inserted message was then removed
        assertTrue(initialMessages.equals(finalData));
    }



    /**
     * When a user up votes a message, the messages "likes" should be increased by 1.
     */
    public void testPUTUp() {
        App a = new App();

        // Create a new message
        Message newMessage = new Message();
        newMessage.setTitle("TestTitle");
        newMessage.setBody("TestMessage");
        newMessage.setLikes(5);                       // Set the new messages likes to 5
        final Date createdDate = new Date();
        newMessage.setCreatedDate(createdDate);

        Long ID = a.createPost(newMessage, 1);  // This method should return the primary key for the
                                                      // newly created row.

        // Get the newly created message
        Message message = a.getMessageByID(ID);

        a.like(message, 0);  // Up vote the message, this method should increase the likes
                                    // for that message in the db by one.

        // Get the updated message from the DB
        Message updatedMessage = a.getMessageByID(ID);

        // Verify that the message's likes were increased by 1
        assertTrue(updatedMessage.getLikes() == 6);

        a.removeMessageByID(ID);    // Delete the message by its primary key
    }

    public void testPUTDown() {
        App a = new App();

        // Create a new message
        Message newMessage = new Message();
        newMessage.setTitle("TestTitle");
        newMessage.setBody("TestMessage");
        newMessage.setLikes(5);
        final Date createdDate = new Date();
        newMessage.setCreatedDate(createdDate);

        Long ID = a.createPost(newMessage, 1);

        // Get the newly created message
        Message message = a.getMessageByID(ID);

        a.dislike(message, 0);                           // Decrease the messages likes by 1.

        Message updatedMessage = a.getMessageByID(ID);          // Get the updated message
        assertTrue(updatedMessage.getLikes() == 4);    // Verify that the likes decreased

        a.removeMessageByID(ID);
    }
}
