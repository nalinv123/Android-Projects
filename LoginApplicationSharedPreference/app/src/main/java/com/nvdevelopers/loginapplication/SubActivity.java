package com.nvdevelopers.loginapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView = findViewById(R.id.text);
        SharedPreferences sharedPreferences = getSharedPreferences("LoginApplicationSharedPreference", Context.MODE_PRIVATE);
        String username, password;
        username = sharedPreferences.getString("username", "");
        password = sharedPreferences.getString("password", "");

        textView.setText("Welcome user " + username + " with password " + password);
    }
}
