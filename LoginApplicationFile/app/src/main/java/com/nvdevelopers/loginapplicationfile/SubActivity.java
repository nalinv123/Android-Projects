package com.nvdevelopers.loginapplicationfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SubActivity extends AppCompatActivity {

    String filename = "Login Application File";
    int character;
    String filedata = "";
    char[] arr = new char[20];
    TextView textView;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView = findViewById(R.id.text);

        try {
            FileInputStream inputStream = openFileInput(filename);
            while ((character = inputStream.read()) != -1)
            {
                System.out.println((char)character);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
