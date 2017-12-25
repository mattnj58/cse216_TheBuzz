package edu.lehigh.cse216.phase0.android.erv318.ravenclaw_androidrecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONObject;

//class to create new message and pass it to the main activity
public class Comment extends AppCompatActivity {

    String comment = null;
    private EditText commentText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_comment);

        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fabAddComment);

        //on button click send comment to the comments page
        commentText = (EditText) findViewById(R.id.addComment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comment = commentText.getText().toString();
                Intent i = new Intent(Comment.this, ViewComments.class);
                i.putExtra("Comments", comment);

                startActivity(i);
            }
        });
    }


}
