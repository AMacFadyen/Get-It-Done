package com.example.alex.getitdone;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class TasksListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_list);
        DBHelper dbHelper = new DBHelper(this);
        ArrayList<Task> taskList = dbHelper.all();

        TasksListAdapter taskAdapter = new TasksListAdapter(this, taskList);
        ListView listView = (ListView)findViewById(R.id.task_list);
        listView.setAdapter(taskAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.add_task:
                startActivity(new Intent(this, activity_add_task.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void getTask(View listItem){
        Task task = (Task) listItem.getTag();
        Intent i = new Intent(this, TaskActivity.class);
        i.putExtra("name", task.getName());
        i.putExtra("details", task.getDetails());
        i.putExtra("category", task.getCategory());
        i.putExtra("id", task.getId());
        i.putExtra("status", task.getStatus());
        startActivity(i);
    }

}
