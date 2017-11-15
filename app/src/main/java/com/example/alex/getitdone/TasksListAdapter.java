package com.example.alex.getitdone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.id;

/**
 * Created by Alex on 10/11/2017.
 */

public class TasksListAdapter extends ArrayAdapter<Task> {

    public TasksListAdapter(Context context, ArrayList<Task> tasks){
        super(context, 0, tasks);
    }

    public View getView(int position, View listItemView, ViewGroup parent){
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.task_item, parent, false);
        }
        Task currentTask = getItem(position);
        TextView name = (TextView)listItemView.findViewById(R.id.taskName);
        name.setText(currentTask.getName());
        TextView details = (TextView)listItemView.findViewById(R.id.taskDetails);
        details.setText(currentTask.getDetails());
        TextView category = (TextView)listItemView.findViewById(R.id.taskCategory);
        category.setText(currentTask.getCategory());

        listItemView.setTag(currentTask);

        return listItemView;
    }
}
