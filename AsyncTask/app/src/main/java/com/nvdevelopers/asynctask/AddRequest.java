package com.nvdevelopers.asynctask;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nalin on 05/01/18.
 */

public class AddRequest extends StringRequest {
    private static final String URL = "http://192.168.1.3/add.php";
    HashMap<String, String> params;

    public AddRequest(String  First, String  Second, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, URL, listener, errorListener);
        params = new HashMap<>();
        params.put("First", First);
        params.put("Second", Second);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}