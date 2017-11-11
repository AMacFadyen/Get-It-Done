package com.example.alex.getitdone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {

    TextView nameText;
    TextView detailsText;
    TextView categoryText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String details = extras.getString("details");
        String category = extras.getString("category");

        nameText = (TextView)findViewById(R.id.taskNameDisplay);
        nameText.setText(name);
        detailsText = (TextView)findViewById(R.id.taskDetailsDisplay);
        detailsText.setText(details);
        categoryText = (TextView)findViewById(R.id.taskCategoryDisplay);
        categoryText.setText(category);
    }
}
