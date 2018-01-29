package com.nvdevelopers.messagingapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edMobile, edMessage;
    Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edMobile = findViewById(R.id.edMobile);
        edMessage = findViewById(R.id.edMessage);
        btSend = findViewById(R.id.btSend);

        sendMessage();
    }

    private void sendMessage() {
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edMobile.getText().toString().equals(""))
                {
                    edMobile.setError("Please enter mobile number");
                    edMobile.requestFocus();
                    return;
                }
                if (edMessage.getText().toString().equals(""))
                {
                    edMessage.setError("Please enter message to send");
                    edMessage.requestFocus();
                    return;
                }

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(edMobile.getText().toString(),
                            null,
                            edMessage.getText().toString(),
                            null,
                            null);
                    Toast.makeText(MainActivity.this, "Message Sent", Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
