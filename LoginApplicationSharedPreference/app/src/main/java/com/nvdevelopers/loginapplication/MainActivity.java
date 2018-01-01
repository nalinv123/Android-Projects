package com.nvdevelopers.loginapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btLogin;
    TextView tvTotalAttepts;
    int iCnt = 3;

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
        if (edUsername.getText().toString().length() == 0)
        {
            edUsername.setError("Please enter username");
            edUsername.requestFocus();
            return;
        }

        if (edPassword.getText().toString().length() == 0)
        {
            edPassword.setError("Please enter password");
            edPassword.requestFocus();
            return;
        }

        if ((edUsername.getText().toString().equals("admin") && (edPassword.getText().toString().equals("admin123"))))
        {
            SharedPreferences sharedPreferences = getSharedPreferences("LoginApplicationSharedPreference", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("username", edUsername.getText().toString());
            editor.putString("password", edPassword.getText().toString());

            editor.commit();

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
