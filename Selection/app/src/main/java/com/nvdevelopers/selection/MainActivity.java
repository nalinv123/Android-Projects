package com.nvdevelopers.selection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btSubmit;
    CheckBox cbPPA, cbLB, cbMultiOS;
    TextView tvResult;
    int iCnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSubmit = findViewById(R.id.btSubmit);
        cbPPA = findViewById(R.id.cbPPA);
        cbLB = findViewById(R.id.cbLB);
        cbMultiOS = findViewById(R.id.cbMultiOS);
        tvResult = findViewById(R.id.tvResult);

        doSelection();
    }

    private void doSelection() {
        cbPPA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbPPA.isChecked())
                {
                    iCnt++;
                    Toast.makeText(MainActivity.this,"PPA batch selected",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    iCnt--;
                }
            }
        });
        cbLB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbLB.isChecked())
                {
                    iCnt++;
                    Toast.makeText(MainActivity.this,"LB batch selected",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    iCnt--;
                }
            }
        });
        cbMultiOS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbMultiOS.isChecked())
                {
                    iCnt++;
                    Toast.makeText(MainActivity.this,"MultiOS batch selected",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    iCnt--;
                }
            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkSelection();
            }
        });
    }

    private void checkSelection() {
        tvResult.setText("");
        if (iCnt == 3)
        {
            tvResult.setText("You have selected 3 batches");
            return;
        }
        if (iCnt == 2)
        {
            tvResult.setText("You have selected 2 batches");
            return;
        }
        if (iCnt == 1)
        {
            tvResult.setText("You have selected only one batch");
            return;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}
