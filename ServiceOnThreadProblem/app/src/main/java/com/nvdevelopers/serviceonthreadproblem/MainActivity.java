package com.nvdevelopers.serviceonthreadproblem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btStartService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btStartService = findViewById(R.id.btStartService);

        Toast.makeText(this, "Main thread started with thread id" + Thread.currentThread().getId(), Toast.LENGTH_SHORT).show();

        createService();
    }

    private void createService() {
        btStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });
    }
}
