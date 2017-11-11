package com.example.alex.getitdone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);
    }

    public void goToTaskList(View button){
        Intent i = new Intent(this, TasksListActivity.class);
        startActivity(i);
    }

    public void goToCreateTask(View button){
        Intent i = new Intent(this, activity_add_task.class );
        startActivity(i);
    }
}
