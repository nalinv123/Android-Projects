package com.nvdevelopers.mailingapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edMail, edMessage;
    Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edMail = findViewById(R.id.edEmail);
        edMessage = findViewById(R.id.edMessage);
        btSend = findViewById(R.id.btSend);

        sendEmail();
    }

    private void sendEmail() {
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edMail.getText().toString().equals(""))
                {
                    edMail.setError("Please enter mail address");
                    edMail.requestFocus();
                    return;
                }
                if (edMessage.getText().toString().equals(""))
                {
                    edMessage.setError("Please enter message to send");
                    edMessage.requestFocus();
                    return;
                }

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String [] {edMail.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Test Mail");
                intent.putExtra(Intent.EXTRA_TEXT, edMessage.getText().toString());
                intent.setType("plain/text");
                startActivity(Intent.createChooser(intent, "Choose an email client"));
            }
        });
    }
}
