package com.example.uwmlh.psykick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CreateNotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notification);

        /**
         * populates mailing list view with the mailing list information
         */
        ListView mailingList = (ListView) findViewById(R.id.recipients);
        RecipientManager listManager = new RecipientManager();
        RecipientAdapter adapter = new RecipientAdapter(this, listManager.getList());
        mailingList.setAdapter(adapter);
        Button submit = (Button) findViewById(R.id.send);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     Toast.makeText(this, "Message sent!", Toast.LENGTH_LONG);
            }
        });
    }

    public static class RecipientViewHolder {
        public TextView code;
        public TextView courseName;
        public TextView profName;
        public TextView email;
    }
}
