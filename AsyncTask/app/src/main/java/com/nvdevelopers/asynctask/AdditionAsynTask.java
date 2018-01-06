package com.nvdevelopers.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

/**
 * Created by nalin on 04/01/18.
 */

public class AdditionAsynTask extends AsyncTask {

    private Context context;

    AdditionAsynTask(Context context)
    {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Object... objects) {
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "Result : " + response, Toast.LENGTH_LONG).show();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Unable to connect to network", Toast.LENGTH_LONG).show();
            }
        };
        AddRequest addRequest = new AddRequest(String.valueOf(objects[0]), String.valueOf(objects[1]), listener, errorListener);
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(addRequest);
        return null;
    }
}
