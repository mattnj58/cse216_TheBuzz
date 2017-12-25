package edu.lehigh.cse216.ravenclaw.backend.myw219.util;

import edu.lehigh.cse216.ravenclaw.backend.myw219.util.PasswordHasher;
import junit.framework.TestCase;


/**
 * Created by derekhuber on 3/9/17.
 */
public class PasswordHasherTest extends TestCase {

    public PasswordHasherTest(){

    }

    public void testGenerateStrongPasswordHash(){
        PasswordHasher p = new PasswordHasher();
        String password = "password";
        byte [] salt = new byte[];
        String testString;
        try{
            testString = p.generateStrongPasswordHash(password, salt);
        }catch(Exception e){
            e.printStackTrace();
        }
        String hex = p.toHex(salt);
        assertTrue(testString.equals(hex));

    }

}
