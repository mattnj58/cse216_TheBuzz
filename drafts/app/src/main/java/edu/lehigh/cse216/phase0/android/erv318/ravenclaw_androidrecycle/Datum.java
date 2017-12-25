package edu.lehigh.cse216.phase0.android.erv318.ravenclaw_androidrecycle;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Calendar;

import static android.content.ComponentName.readFromParcel;

/**
 * Created by Evan Vomund on 2/20/2017.
 */

//This is the message object that will be stored in the database
public class Datum implements Parcelable{

    private String title = null;
    private String body = null;
    private int likes;
    private int dislikes;
    Calendar date;
    private String strDate;

    Datum (String title, String body) {
        this.title=title;
        this.body = body;
        this.likes=0;
        this.dislikes=0;
        date = Calendar.getInstance();
        strDate = this.printDate();
    }

    protected Datum(Parcel in) {
        readFromParcel(in);
    }

    //Parcilable is for passing object between activities
    public static final Parcelable.Creator<Datum> CREATOR = new Parcelable.Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() { return dislikes; }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDislikes(int dislikes) { this.dislikes = dislikes; }

    public String getDate() {
        return strDate;
    }

    public String printDate() {
        return (Integer.toString(this.date.get(Calendar.MONTH)+1))+"/"+
                (Integer.toString(this.date.get(Calendar.DAY_OF_MONTH)))+"/"+
                (Integer.toString(this.date.get(Calendar.YEAR)));
    }

    //Converts date object to a sting in the form of mm/dd/yyyy
    public Calendar readDate(String date) {
        Calendar returner = Calendar.getInstance();

        String month = "";
        String day = "";
        String year = "";
        int i;
        for (i=0; i<date.length(); i++) {
            if (date.charAt(i)!='/') {
                month+=date.charAt(i);
            } else {
                break;
            }
        }
        int j;
        for (j=i; i<date.length(); i++) {
            if (date.charAt(i)!='/') {
                day+=date.charAt(i);
            } else {
                break;
            }
        }
        int k;
        for (k=j; i<date.length(); i++) {
            if (date.charAt(i)!='/') {
                year+=date.charAt(i);
            } else {
                break;
            }
        }
    returner.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        return returner;
    }

    // TODO: 2/20/2017
    //Mock data. This can be replaced with the database in the future
    public static ArrayList<Datum> createDatumList() {
        ArrayList<Datum> datumList = new ArrayList<Datum>();
        datumList.add(new Datum("Test Title", "This class is interesting. I am learning android." +
                " I am writing random stuff. This stuff is interesting."));
        datumList.add(new Datum("boom", "banana"));
        datumList.add(new Datum("cats", "candybar"));
        datumList.add(new Datum("dogs", "dinosaur"));
        datumList.add(new Datum("begals", "banana"));
        datumList.add(new Datum("coke", "candybar"));
        datumList.add(new Datum("dads", "dinosaur"));
        datumList.add(new Datum("bronze", "banana"));
        datumList.add(new Datum("creape", "candybar"));
        return datumList;
    }

    //These methods implement the parcilable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(body);
        dest.writeInt(likes);
        dest.writeInt(dislikes);
        dest.writeString(strDate);
    }

    public void readFromParcel(Parcel in) {
        title = in.readString();
        body = in.readString();
        likes = in.readInt();
        dislikes = in.readInt();
        strDate = in.readString();//implement a read date class
    }
}
