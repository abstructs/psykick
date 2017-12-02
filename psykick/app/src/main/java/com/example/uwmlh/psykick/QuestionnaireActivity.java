package com.example.uwmlh.psykick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class QuestionnaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        String [] questions = getResources().getStringArray(R.array.questions);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, questions);
        ListView questionsList = (ListView) findViewById(R.id.questions);
        questionsList.setAdapter(adapter);
    }
}
