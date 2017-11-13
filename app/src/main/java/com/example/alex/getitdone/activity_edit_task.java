package com.example.alex.getitdone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.id;

public class activity_edit_task extends AppCompatActivity {

    EditText updateName;
    EditText updateDetails;
    EditText updateCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        updateName = (EditText)findViewById(R.id.editTaskNameInput);
        updateCategory = (EditText)findViewById(R.id.editTaskCategoryInput);
        updateDetails = (EditText)findViewById(R.id.editTaskDetailsInput);
    }

    public void updateTask(View button){
        DBHelper dbHelper = new DBHelper(this);

        String name = updateName.getText().toString();
        String category = updateCategory.getText().toString();
        String details = updateDetails.getText().toString();
        dbHelper.update(id, name, details, category);
        Intent i = new Intent(this, TaskActivity.class);
        startActivity(i);
    }
}