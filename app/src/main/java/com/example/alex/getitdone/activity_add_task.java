package com.example.alex.getitdone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class activity_add_task extends AppCompatActivity {

    EditText nameText;
    EditText categoryText;
    EditText detailsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        nameText = (EditText)findViewById(R.id.newTaskNameInput);
        categoryText = (EditText)findViewById(R.id.newTaskCategoryInput);
        detailsText = (EditText)findViewById(R.id.newTaskDetailsInput);
    }

    public void addTask(View button){
        DBHelper dbHelper = new DBHelper(this);
        String name = nameText.getText().toString();
        String details = detailsText.getText().toString();
        String category = categoryText.getText().toString();
        dbHelper.save(name, details, category, false);
        Intent i = new Intent(this, TasksListActivity.class);
        startActivity(i);
        }
}
