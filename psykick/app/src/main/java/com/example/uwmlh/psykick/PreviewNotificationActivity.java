package com.example.uwmlh.psykick;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreviewNotificationActivity extends AppCompatActivity {

    String [] recipients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_notification);
        EditText emailBody = (EditText) findViewById(R.id.email_body);
        final String s = "Hello Professor,\n\nI have become unwell so I will not be able to attend today's class." +
                "\n\n" + MainActivity.user + "\n" + MainActivity.studentNo;
        emailBody.setText(s);

        Intent intent = getIntent();
        recipients = intent.getStringArrayExtra("recipients");

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail(recipients, "Unable to attend class", s);
                Toast.makeText(getApplicationContext(), "Message sent!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void sendEmail(String[] addresses, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "ngonathanieldean@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        Log.i("PSYKICK", "send email intent");
        Log.i("PSYKICK", "sending the email");
        startActivity(Intent.createChooser(intent, "Send email using..."));
    }
}
