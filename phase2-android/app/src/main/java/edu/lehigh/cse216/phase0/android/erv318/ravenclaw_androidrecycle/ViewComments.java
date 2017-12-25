package edu.lehigh.cse216.phase0.android.erv318.ravenclaw_androidrecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by wilsil on 3/9/17.
 */

public class ViewComments extends AppCompatActivity {


    //right now commments are on a separate page and are in a text view, should probably be a list view
    private TextView comment;
    String inComm;
    private Datum datum;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcomments);


        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            datum = extras.getParcelable("Datum");
            inComm = datum.getComment();
        }

        comment = (TextView) findViewById(R.id.comments);
        comment.setText("Enter Comments here");

    }

}
