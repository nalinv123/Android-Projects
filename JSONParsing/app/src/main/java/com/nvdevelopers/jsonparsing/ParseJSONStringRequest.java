package com.nvdevelopers.jsonparsing;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.net.URL;

/**
 * Created by nalin on 07/01/18.
 */

public class ParseJSONStringRequest extends StringRequest {

    private static final String URL = "http://192.168.1.6/json.php";

    ParseJSONStringRequest(Response.Listener<String> listener, Response.ErrorListener errorListener)
    {
        super(Method.POST, URL, listener, errorListener);
    }
}
