package com.nvdevelopers.callingapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btCallDirectly, btCallOptions;
    EditText edMobileNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCallDirectly = findViewById(R.id.btCallDirectly);
        btCallOptions = findViewById(R.id.btCallOptions);
        edMobileNo = findViewById(R.id.edMobileNo);

        makeCall();
    }

    private void makeCall() {
        btCallDirectly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edMobileNo.getText().toString().equals("")) {
                    edMobileNo.setError("Please enter mobile no");
                    edMobileNo.requestFocus();
                    return;
                }
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + edMobileNo.getText().toString()));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });

        btCallOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edMobileNo.getText().toString().equals(""))
                {
                    edMobileNo.setError("Please enter mobile no");
                    edMobileNo.requestFocus();
                    return;
                }
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + edMobileNo.getText().toString()));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}
