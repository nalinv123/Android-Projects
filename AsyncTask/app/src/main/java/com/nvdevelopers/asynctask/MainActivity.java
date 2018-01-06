package com.nvdevelopers.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edFirst, edSecond;
    Button btAdd;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edFirst = findViewById(R.id.edFirst);
        edSecond = findViewById(R.id.edSecond);
        btAdd = findViewById(R.id.btAdd);
        tvResult = findViewById(R.id.tvResult);

        getResultAsynchronously();
    }

    private void getResultAsynchronously() {
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edFirst.getText().toString().equals(""))
                {
                    edFirst.setError("Enter 1st number");
                    edFirst.requestFocus();
                    return;
                }
                if (edSecond.getText().toString().equals(""))
                {
                    edSecond.setError("Enter 2nd number");
                    edSecond.requestFocus();
                    return;
                }
                String FirstNumber = edFirst.getText().toString();
                String SecondNumber = edSecond.getText().toString();
                AdditionAsynTask additionAsynTask = new AdditionAsynTask(MainActivity.this);
                additionAsynTask.execute(FirstNumber, SecondNumber);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}
