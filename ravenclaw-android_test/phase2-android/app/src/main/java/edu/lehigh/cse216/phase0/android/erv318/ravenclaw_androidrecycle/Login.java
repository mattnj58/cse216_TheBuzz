package edu.lehigh.cse216.phase0.android.erv318.ravenclaw_androidrecycle;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Login extends AppCompatActivity {


    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    EditText username;
    EditText passwordText;
    Button loginButton;
    Button signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = (EditText) findViewById(R.id.input_user); //input user and pass reference the fields in activity_login.xml
        passwordText = (EditText) findViewById(R.id.input_pass);


        loginButton = (Button) findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = username.getText().toString();
                String password = passwordText.getText().toString();
                login(email, password);
            }
        });

        //button to go back to the signup page
        signupLink = (Button) findViewById(R.id.button_signup);
        signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });
    }

    //validate the email and password and then enter the main activity
    public void login(final String email, final String password) {
        if(validate(email, password)) {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            //this section currently does nothing but it should get json data from db.
            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");

                        if (success) {
                            String email = jsonResponse.getString("email");
                            int password = jsonResponse.getInt("password");

                            Intent intent = new Intent(Login.this, MainActivity.class);
                            intent.putExtra("email", email);
                            intent.putExtra("password", password);
                            Login.this.startActivity(intent);
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                            builder.setMessage("Login Failed");
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            RequestQueue queue = Volley.newRequestQueue(Login.this);
        }
    }

    //just makes sure email/password aren't blank
    public boolean validate(String email, String password) {
        boolean valid = true;

        if (email.isEmpty()) {
            username.setError("enter an email address");
            valid = false;
        } else {
            username.setError(null);
        }

        if (password.isEmpty()) {
            passwordText.setError("enter a password");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;
    }

}