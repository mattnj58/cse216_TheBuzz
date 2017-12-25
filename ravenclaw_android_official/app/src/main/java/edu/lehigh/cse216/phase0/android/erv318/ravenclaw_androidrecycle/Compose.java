package edu.lehigh.cse216.phase0.android.erv318.ravenclaw_androidrecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//class to create new message and pass it to the main activity
public class Compose extends AppCompatActivity {

    String title = null;
    String body = null;
    private EditText enterMessage1;
    private EditText enterMessage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_compose);

        //detect button push. I used fab because it remains in place despite the text size.
        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fabAddArticle);
        enterMessage1 = (EditText) findViewById(R.id.addTitle);
        enterMessage2 = (EditText) findViewById(R.id.addBody);
        button.setOnClickListener(new View.OnClickListener() {
            //If more data is entered, consider creating the datum here and passing it as
            //a parcelable to the main activity as I do when passing to to the read activity
            @Override
            public void onClick(View v) {
                title = enterMessage1.getText().toString();
                body = enterMessage2.getText().toString();
                Intent i = new Intent(Compose.this, MainActivity.class);
                i.putExtra("Title", title);
                i.putExtra("Body", body);

                startActivity(i);
            }
        });
    }


}
