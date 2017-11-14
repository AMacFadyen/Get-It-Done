package com.example.alex.getitdone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import static android.R.attr.checked;
import static android.R.attr.id;
import static android.R.attr.name;
import static android.R.attr.start;

public class TaskActivity extends AppCompatActivity {

    Task task;
    TextView nameText;
    TextView detailsText;
    TextView categoryText;
    CheckBox taskCompleteBox;
    Bundle extras;
    String name;
    String details;
    String category;
    Integer id;
    Boolean status;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);


        extras = getIntent().getExtras();
        id = extras.getInt("id");

        DBHelper dbHelper = new DBHelper(this);


        task = dbHelper.findById(id);
        name = task.getName();
        details = task.getDetails();
        category = task.getCategory();
        status = task.getStatus();

        nameText = (TextView)findViewById(R.id.taskNameDisplay);
        nameText.setText(name);
        detailsText = (TextView)findViewById(R.id.taskDetailsDisplay);
        detailsText.setText(details);
        categoryText = (TextView)findViewById(R.id.taskCategoryDisplay);
        categoryText.setText(category);
        taskCompleteBox = (CheckBox) findViewById(R.id.checkBox);
        taskCompleteBox.setChecked(status);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.task_list:
                startActivity(new Intent(this, TasksListActivity.class));
                return true;
            case R.id.add_task:
                startActivity(new Intent(this, activity_add_task.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void deleteTask(View button){
        Integer id = extras.getInt("id");
        DBHelper dbHelper = new DBHelper(this);
        dbHelper.delete(id);
        Intent intent = new Intent(this, TasksListActivity.class);
        startActivity(intent);
    }

    public void onCheckBoxClick(View button){
        DBHelper dbHelper = new DBHelper(this);
        boolean boxStatus = ((CheckBox) button).isChecked();
        if(boxStatus){
            task.setStatus(true);
        }else{
            task.setStatus(false);
        }
        dbHelper.update(id, name, details, category, task.getStatus());
    }

    public void editTask(View button){
        Intent i = new Intent(this, activity_edit_task.class);
        Integer id = extras.getInt("id");
        String name = extras.getString("name");
        String details = extras.getString("details");
        String category = extras.getString("category");
        i.putExtra("details", details);
        i.putExtra("category", category);
        i.putExtra("name", name);
        i.putExtra("id", id);

        startActivity(i);
    }


}
