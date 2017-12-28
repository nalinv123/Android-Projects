package com.nvdevelopers.radioprogramming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rbC, rbCPP, rbJAVA, rbPHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbC = findViewById(R.id.rbC);
        rbCPP = findViewById(R.id.rbCPP);
        rbJAVA = findViewById(R.id.rbJAVA);
        rbPHP = findViewById(R.id.rbPHP);

        selectRadioButton();
    }

    private void selectRadioButton() {
        rbC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rbC.isChecked() == true)
                {
                    Toast.makeText(MainActivity.this, "Book for C Programming Language is 'Let Us C'",Toast.LENGTH_LONG).show();
                }
            }
        });

        rbCPP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rbCPP.isChecked())
                {
                    Toast.makeText(MainActivity.this, "Book for C++ Programming Language is 'Let Us C++'",Toast.LENGTH_LONG).show();
                }
            }
        });

        rbJAVA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rbJAVA.isChecked())
                {
                    Toast.makeText(MainActivity.this, "Book for JAVA Programming Language is 'Core JAVA'",Toast.LENGTH_LONG).show();
                }
            }
        });

        rbPHP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rbPHP.isChecked())
                {
                    Toast.makeText(MainActivity.this, "Book for PHP Programming Language is 'Web development using PHP'",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}
