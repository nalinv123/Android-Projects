package com.nvdevelopers.callbackflow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("On create", "In onCreate() method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("On destroy", "In onDestroy() method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("On start", "In onStart() method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("On stop", "In onStop() method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("On resume", "In onResume() method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("On pause", "In onPause() method");
    }
}
