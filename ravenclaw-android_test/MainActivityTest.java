import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Activity;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.filters.LargeTest;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;



@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    public static final String STRING_TO_BE_TYPED = "Testing";


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
            
    @Test
    public void testLogin(){
    	onView(withId(R.id.Login))
    		.perform(click());
    	onView(withId(R.id.Login))
    		.check(loginsuccessful);
    }
    
    @Test
    public void testComment(){
    	onView(withId(R.id.Comment))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.Comment)).perform(click());
        
    	onView(withId(R.id.Comment)).check(matches(withText(STRING_TO_BE_TYPED)));
    }
    
    @Test
    public void testSignup(){
    	onView(withId(R.id.Signup))
    		.perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
    	onView(withId(R.id.Signup)).perform(click());
    	onView(withId(R.id.Signup)).perform(signup("testname", "testemail", "testpass"));
    	onView(withId(R.id.Signup)).check(signupsuccessful);
    }
    
    @Test
    public void testCompose(){
       	onView(withId(R.id.Compose))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.Compose)).perform(click());
        
    	onView(withId(R.id.Compose)).check(matches(withText(STRING_TO_BE_TYPED)));
    }
    
    @Test
    public void testRead(){
    	onView(withId(R.id.Read))
    		.perform(click());
    	onView(withId(R.id.Read))
    		.check();
    }
    	
