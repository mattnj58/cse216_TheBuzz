package edu.lehigh.cse216.phase0.android.erv318.ravenclaw_androidrecycle;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Read extends AppCompatActivity {
    String title=null;
    String body=null;
    String likes;
    String dislikes;
    String date;
    int likesIn=0;
    int dislikesIn=0;

    ArrayList comments;

    private TextView titleOut;
    private TextView bodyOut;
    private TextView likesOut;
    private TextView dateOut;
    private TextView dislikesOut;
    private Datum datum;
    private Button commentButton;
    private Button openCommentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        //get passed in variables ad a parcilable datum which we read from
        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            datum = extras.getParcelable("Datum");
            title = datum.getTitle();
            body = datum.getBody();
            likesIn = datum.getLikes();
            likes = Integer.toString(likesIn);
            dislikesIn = datum.getDislikes();
            dislikes = Integer.toString(dislikesIn);
            date = datum.getDate();
        }
        //Print everything out
        //The R.id.___ refers to the activity_read where I created those variables to print to the screen
        titleOut = (TextView) findViewById(R.id.titleOut);
        titleOut.setText(title);
        likesOut = (TextView) findViewById(R.id.likesOut);
        likesOut.setText(likes);
        dislikesOut = (TextView) findViewById(R.id.dislikesOut);
        dislikesOut.setText(dislikes);
        bodyOut = (TextView) findViewById(R.id.bodyOut);
        bodyOut.setText(body);
        dateOut = (TextView) findViewById(R.id.dateOut);
        dateOut.setText(date);

        //Add commment button that will open a new activity to comment and post it onto this page
        commentButton = (Button) findViewById(R.id.btn_comment);
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comment();
            }
        });


        //press button to open new page to show comments
        openCommentButton = (Button) findViewById(R.id.btn_opencomment);
        openCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Read.this, ViewComments.class);
                startActivity(intent);
            }
        });




        //Add like when button is pressed
        FloatingActionButton likeButton = (FloatingActionButton) findViewById(R.id.fabup);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likesIn++;
                likes = Integer.toString(likesIn);
                likesOut.setText(likes);
            }
        });

        //Add dislike when button is pressed
        FloatingActionButton disButton = (FloatingActionButton) findViewById(R.id.fabdown);
        disButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dislikesIn++;
                dislikes = Integer.toString(dislikesIn);
                dislikesOut.setText(dislikes);
            }
        });

    }

    //open the activity to comment on the post
    public void comment() {
        Intent intent = new Intent(Read.this, Comment.class);
        startActivity(intent);
    }

}
