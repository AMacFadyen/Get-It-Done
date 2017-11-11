package com.example.alex.getitdone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class activity_add_task extends AppCompatActivity {

    EditText nameText;
    EditText categoryText;
    EditText detailsText;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        nameText = (EditText)findViewById(R.id.taskNameInput);
        categoryText = (EditText)findViewById(R.id.taskCategoryInput);
        detailsText = (EditText)findViewById(R.id.taskDetailsInput);
    }

    public void addTask(View button){
        dbHelper = new DBHelper(this);
        String name = nameText.getText().toString();
        String details = detailsText.getText().toString();
        String category = categoryText.getText().toString();
        Task task = new Task(name, details, category);
        task.save(dbHelper);
        Intent i = new Intent(this, TasksListActivity.class );
        startActivity(i);
        }
}
