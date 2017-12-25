package edu.lehigh.cse216.phase0.android.erv318.ravenclaw_androidrecycle;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Evan Vomund on 2/20/2017.
 */

public class DatumAdapter extends RecyclerView.Adapter<DatumAdapter.ViewHolder> {

    private List<Datum> mDatum;
    private Context mContext;

    public DatumAdapter(Context context, List<Datum> datums) {
        mDatum = datums;
        mContext = context;
    }

    private Context getmContext() {
        return mContext;
    }

    @Override
    public DatumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //inflates our layout with the recycle view list
        View datumView = inflater.inflate(R.layout.item_datum, parent, false);

        ViewHolder viewHolder = new ViewHolder(context, datumView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DatumAdapter.ViewHolder viewHolder, int position) {
        Datum datum = mDatum.get(position);

        TextView textView = viewHolder.nameTextView;
        textView.setText(datum.getTitle());
        TextView textView2 = viewHolder.date;
        textView2.setText(datum.printDate());
        FloatingActionButton fab = viewHolder.button;
    }

    @Override
    public int getItemCount() {
        return mDatum.size();
    }


// Provide a direct reference to each of the views within a data item
// Used to cache the views within the item layout for fast access
public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    // Your holder should contain a member variable
    // for any view that will be set as you render a row
    public TextView tvName;
    public TextView nameTextView;
    public TextView date;
    public FloatingActionButton button;
    private Context context;

    // We also create a constructor that accepts the entire item row
    // and does the view lookups to find each subview
    public ViewHolder(Context context, View itemView) {
        // Stores the itemView in a public final member variable that can be used
        // to access the context from any ViewHolder instance.
        super(itemView);
  //      this.tvName = (TextView) itemView.findViewById(R.id.rvMessages);
        nameTextView = (TextView) itemView.findViewById(R.id.datum_title);
        date = (TextView) itemView.findViewById(R.id.date);
        button = (FloatingActionButton) itemView.findViewById(R.id.fab);
        this.context = context;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();
        if (position == R.id.fab) {
            Toast.makeText(context, "blah", Toast.LENGTH_SHORT).show();
        }
        if (position != RecyclerView.NO_POSITION) {
       Datum d = mDatum.get(position);

            String date = d.printDate();
            Intent i = new Intent(mContext,Read.class);
            i.putExtra("Datum", d);
            mContext.startActivity(i);

        }
    }

}
}
