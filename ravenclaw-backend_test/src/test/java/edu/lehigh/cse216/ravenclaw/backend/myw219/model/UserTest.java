package edu.lehigh.cse216.ravenclaw.backend.myw219.model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;

/**
 * Created by derekhuber on 3/9/17.
 */
public class UserTest extends TestCase {

    public UserTest(){

    }

    public void testUserId(){
        User u = new User();
        Long uid = new Long(12345);
        u.setUserId(uid);
        assertTrue(u.getUserId().equals(uid));
    }

    public void testUsername(){
        User u = new User();
        u.setUsername("name");
        assertTrue(u.getUsername().equals("name"));
    }

    public void testRealName(){
        User u = new User();
        u.setRealname("realname");
        assertTrue(u.getRealname().equals("realname"));
    }

    public void testEmail(){
        User u = new User();
        u.setEmail("email");
        assertTrue(u.getEmail().equals("email"));
    }

    public void testSalt(){
        User u = new User();
        u.setSalt("salt");
        assertTrue(u.getSalt().equals("salt"));
    }

    public void testPassword(){
        User u = new User();
        u.setPassword("pass");
        assertTrue(u.getPassword().equals("pass"));
    }

    public void testUpvotedMessages(){
        User u = new User();
        ArrayList list = new ArrayList<Message>();
        Message firstElement = new Message();
        firstElement.setLikes(1);
        Message secondElement = new Message();
        secondElement.setLikes(2);
        list.add(firstElement);
        list.add(secondElement);
        u.setUpVotedMessages(list);
        assertTrue(u.getUpVotedMessages().equals(list));
    }

    public void testDownvotedMessages(){
        User u = new User();
        ArrayList list = new ArrayList<Message>();
        Message firstElement = new Message();
        firstElement.setLikes(-1);
        Message secondElement = new Message();
        secondElement.setLikes(-2);
        list.add(firstElement);
        list.add(secondElement);
        u.setDownVotedMessages(list);
        assertTrue(u.getDownVotedMessages().equals(list));
    }



}
