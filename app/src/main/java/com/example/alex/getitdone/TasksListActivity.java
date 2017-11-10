package com.example.alex.getitdone;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class TasksListActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_list);
        dbHelper = new DBHelper(this);

        ArrayList<Task> taskList = dbHelper.all();

        TasksListAdapter taskAdapter = new TasksListAdapter(this,taskList);
        ListView listView = (ListView)findViewById(R.id.task_list);
        listView.setAdapter(taskAdapter);
    }

    public void getTask(View listItem){
        Task task = (Task) listItem.getTag();
        Intent i = new Intent(this, TaskActivity.class);
        i.putExtra("name", task.getName());
        i.putExtra("details", task.getDetails());
        i.putExtra("category", task.getCategory());
        startActivity(i);
    }

}
