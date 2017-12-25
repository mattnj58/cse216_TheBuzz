package edu.lehigh.cse216.phase0.android.erv318.ravenclaw_androidrecycle;

/**
 * Created by wilsil on 3/5/17.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Signup extends AppCompatActivity {

    SharedPreferences prefs;

    EditText usernameText;
    EditText emailText;
    EditText passwordText;
    Button signupLink;
    Button loginLink;

    //String regUrl = "https://shrouded-springs-57791.herokuapp.com/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //prefs = getSharedPreferences(getString(R.string.title_activity_signup), Context.MODE_PRIVATE);

        //go back to login page
        loginLink = (Button) findViewById(R.id.link_login);
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent i = new Intent(Signup.this, Welcome.class);
                 startActivity(i);
            }
        });

        usernameText = (EditText) findViewById(R.id.input_name);
        emailText = (EditText) findViewById(R.id.input_email);
        passwordText = (EditText) findViewById(R.id.input_password);

        signupLink = (Button) findViewById(R.id.link_signup);
        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = usernameText.getText().toString();
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();

                signup(name,email, password);

            }
        });
    }

    public void signup(String name, String email, String password) {
        if(validate()) {

            Response.Listener<String> listener = new Response.Listener<String>(){ //right now this does  nothing but is needed for connected to backend

                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonresponse = new JSONObject(response);
                        String name = jsonresponse.getString("name");
                        String email = jsonresponse.getString("email");
                        String password = jsonresponse.getString("password");
                    }
                    catch(JSONException e) {
                        e.printStackTrace();
                    }
                }
            };

            RequestQueue queue = Volley.newRequestQueue(this);


            //not sure if this how he wanted the email registation done, but
            //this sends an email to the given email with a message that just repeats their info
            Intent i = new Intent(Intent.ACTION_SEND);
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{email});

            i.putExtra(Intent.EXTRA_SUBJECT, "RavenClaw User Registration");
            i.putExtra(Intent.EXTRA_TEXT, "Your username is" + name + "and password is " + password);

            i.setType("message/rfc822");
            startActivity(Intent.createChooser(i, "Choose client"));
        }

    }



    //regex to ensure email is in the form ___@___.___
    public static final Pattern VALID_EMAIL= Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailString) {
        Matcher matcher = VALID_EMAIL.matcher(emailString);
        return matcher.find();
    }

    public boolean validate() {
        boolean valid = true;

        String name = usernameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (name.isEmpty()) { //can change to make sure username isn't already used later
            usernameText.setError("Must have a username");
            valid = false;
        } else {
            usernameText.setError(null);
        }

        if (email.isEmpty() || !validate(email)) {
            emailText.setError("enter a valid email address in correct form");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 7 ) { //check password greater than 6
            passwordText.setError("Password length must be greater than 6");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;
    }

}
