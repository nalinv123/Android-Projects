package com.nvdevelopers.loginapplicationfile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btLogin;
    TextView tvTotalAttepts;
    int iCnt = 3;
    String filename = "Login Application File";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        btLogin = findViewById(R.id.btLogin);
        tvTotalAttepts = findViewById(R.id.tvTotalAttempts);

        tvTotalAttepts.setText("Attempts remaining : " + String.valueOf(iCnt));

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }

    private void doLogin() {
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();
        if (username.length() == 0)
        {
            edUsername.setError("Please enter username");
            edUsername.requestFocus();
            return;
        }

        if (password.length() == 0)
        {
            edPassword.setError("Please enter password");
            edPassword.requestFocus();
            return;
        }

        if ((username.equals("admin") && (password.equals("admin123"))))
        {
            File file = new File(getFilesDir(), filename);

            try {
                FileOutputStream outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                outputStream.write(username.getBytes());
                outputStream.write(password.getBytes());
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            startActivity(intent);
        }
        else
        {
            iCnt--;
            tvTotalAttepts.setText("Attempts remaining : " + String.valueOf(iCnt));
            if (iCnt == 0)
            {
                btLogin.setEnabled(false);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}
