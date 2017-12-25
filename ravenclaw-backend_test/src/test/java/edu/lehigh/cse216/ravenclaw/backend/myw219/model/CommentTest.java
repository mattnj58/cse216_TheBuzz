package edu.lehigh.cse216.ravenclaw.backend.myw219.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by derekhuber on 3/9/17.
 */
public class CommentTest extends TestCase {

    public CommentTest(){

    }

    public void testUserId(){
        Comment c = new Comment();
        Long id = new Long(123456);
        c.setUserId(id);
        assertTrue(c.getUserId() == id);
    }

    public void testMessageId(){
        Comment c = new Comment();
        Long message = new Long("hello");
        c.setMessageId(message);
        assertTrue(c.getMessageId() == message);
    }

    public void testCommentId(){
        Comment c = new Comment();
        Long comm = new Long("hello");
        c.setCommentId(comm);
        assertTrue(c.getCommentId() == comm);
    }

    public void testCommentText(){
        Comment c = new Comment();
        c.setCommentText("comment");
        assertTrue(c.getCommentText().equals("comment"));
    }


}
