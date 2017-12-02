package com.example.uwmlh.psykick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CreateNotificationActivity extends AppCompatActivity {
    String [] recipients;
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


        recipients = new String[5];

        for (int i = 0; i < listManager.getList().size(); i++) {
            Log.i("PSYKICK",listManager.getList().get(i).getEmail());
            recipients[i] += listManager.getList().get(i).getEmail();
        }

        mailingList.setAdapter(adapter);
        Button submit = (Button) findViewById(R.id.send);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PreviewNotificationActivity.class);
                intent.putExtra("recipients", recipients);
                startActivity(intent);
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
