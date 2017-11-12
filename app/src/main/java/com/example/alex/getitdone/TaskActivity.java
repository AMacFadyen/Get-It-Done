package com.example.alex.getitdone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.id;
import static android.R.attr.start;

public class TaskActivity extends AppCompatActivity {

    TextView nameText;
    TextView detailsText;
    TextView categoryText;
    Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        extras = getIntent().getExtras();
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

    public void deleteTask(View button){
        Integer id = extras.getInt("id");
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.delete(id);
        Intent intent = new Intent(this, TasksListActivity.class);
        startActivity(intent);
    }


}
