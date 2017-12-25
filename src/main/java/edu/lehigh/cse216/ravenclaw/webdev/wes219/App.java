package edu.lehigh.cse216.ravenclaw.webdev.wes219;

/**
 * Hello world!
 *
 */
import static spark.Spark.*;
import com.google.gson.*;
import java.util.ArrayList;

class Datum {
    int index;
    String val1;
    String val2;
}

public class App
{
    final ArrayList<Datum> database;
    int index;
    final Gson gson;

    String getAllData() {
        String result = "";
        ArrayList<Datum> results = new ArrayList<Datum>();
        synchronized (database) {
            for (Datum d : database) {
                if(d!= null)
                    results.add(d);
            }
        }
        result = gson.toJson(results);
        return result;
    }

    String insertDatum(Datum d) {
        if(d != null && d.val1 != null && d.val2!=null) {
            synchronized (database) {
                int idx = index++;
                d.index = idx;
                database.add(idx, d);
            }
            return "{\"res\":\"ok\"}";
        } else {
            return "{\"res\":\"bad data\"}";
        }
    }

    App() {
        database = new ArrayList<>();
        index =0;
        gson = new Gson();
    }
    public static void main( String[] args ) {
        App app = new App();
        //Set up static file service
        staticFileLocation("/web");

        get("/", (req,res) -> {
            res.redirect("/index.html");
            return "";
        });
        get("/data", (req, res) -> {
            String result = app.getAllData();
            res.status(200);
            res.type("application/json");
            return result;
        });
        post("/data", (req, res) -> {
            Datum d = app.gson.fromJson(req.body(), Datum.class);
            String result = app.insertDatum(d);
            res.status(200);
            res.type("application/json");
            return result;
        });
        delete("/data/:id" , (req, res) -> {
            String result = "";
            int idx = Integer.parseInt(req.params("id"));
            synchronized (app.database) {
                if(idx < app.database.size() && app.database.get(idx) != null) {
                    app.database.set(idx, null);
                    result = "{\"res\":\"ok\"}";
                } else {
                    result = "{\"res\":\"error\"}";
                }
            }
            return result;
        });
    }
}
