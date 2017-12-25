package edu.lehigh.cse216.ravenclaw.backend.myw219.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by derekhuber on 3/9/17.
 */
public class MessageTest extends TestCase {

    public MessageTest(){

    }

    public void testUserId(){
        Message m = new Message();
        Long uid = new Long(12345);
        m.setUserId(uid);
        assertTrue(m.getUserId().equals(uid));
    }

    public void testMessageId(){
        Message m = new Message();
        Long mid = new Long(12345);
        m.setMessageId(mid);
        assertTrue(m.getMessageId().equals(mid));
    }

    public void testTitle(){
        Message m = new Message();
        m.setTitle("hello");
        assertTrue(m.getTitle().equals("hello"));
    }

    public void testBody(){
        Message m = new Message();
        m.setBody("hello");
        assertTrue(m.getBody().equals("hello"));
    }

    public void testLikes(){
        Message m = new Message();
        m.setLikes(5);
        assertTrue(m.getLikes() == 5);
    }


}
