package com.nvdevelopers.jsonparsing;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nalin on 07/01/18.
 */

public class ParseJSONAsyncTask extends AsyncTask {

    private Context context;
    ArrayList<HashMap<String, String>> list;

    public ParseJSONAsyncTask(Context context)
    {
        this.context = context;
    }
    @Override
    protected Object doInBackground(Object[] objects) {
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, response, Toast.LENGTH_LONG).show();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "unable to connect", Toast.LENGTH_LONG).show();
            }
        };

        ParseJSONStringRequest parseJSONStringRequest = new ParseJSONStringRequest(listener, errorListener);

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(parseJSONStringRequest);
        return null;
    }
}
