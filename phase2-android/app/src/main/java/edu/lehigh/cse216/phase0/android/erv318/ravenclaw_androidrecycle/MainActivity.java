package edu.lehigh.cse216.phase0.android.erv318.ravenclaw_androidrecycle;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Datum> datumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMessages = (RecyclerView) findViewById(R.id.rvMessages);

        datumList = new ArrayList<Datum>();
        datumList.addAll(Datum.createDatumList());


        DatumAdapter adapter = new DatumAdapter(this, datumList);
        rvMessages.setAdapter(adapter);
        rvMessages.setLayoutManager(new LinearLayoutManager(this));

        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            String title = extras.getString("Title");
            String body = extras.getString("Body");
            datumList.add(0,new Datum(title, body));
            //inform the adapter that a new item has been added
            adapter.notifyItemInserted(0);
        }

        //Button to trigger compose activity and add a new message
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, Compose.class));
                    }
                }

        );
    }
}
