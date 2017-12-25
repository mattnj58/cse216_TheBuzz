package edu.lehigh.cse216.ravenclaw.backend.myw219.model;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by derekhuber on 3/9/17.
 */
public class VoteTest extends TestCase {

    public VoteTest(){

    }

    public void testUserId(){
        Vote v = new Vote();
        Long uid = new Long(12345);
        v.setUserId(uid);
        assertTrue(v.getUserId().equals(uid));
    }

    public void testMessageId(){
        Vote v = new Vote();
        Long mid = new Long(123456);
        v.setMessageId(mid);
        assertTrue(v.getMessageId().equals(mid));
    }

    public void testUpVote(){
        Vote v = new Vote();
        v.setUpVote(true);
        assertTrue(v.isUpVote());
    }

}
