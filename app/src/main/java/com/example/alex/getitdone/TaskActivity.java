package com.example.alex.getitdone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String details = extras.getString("details");
        String category = extras.getString("category");
        
    }
}
