package com.example.alex.getitdone;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.alex.getitdone.DBHelper.TASKS_COLUMN_CATEGORY;
import static com.example.alex.getitdone.DBHelper.TASKS_COLUMN_DETAILS;
import static com.example.alex.getitdone.DBHelper.TASKS_COLUMN_NAME;
import static com.example.alex.getitdone.DBHelper.TASKS_TABLE_NAME;

/**
 * Created by Alex on 10/11/2017.
 */

public class Task {
    private Integer id;
    private String name;
    private String details;
    private String category;
//    private Date dueDate;

    public Task(String name, String details, String category) {
        this.name = name;
        this.details = details;
        this.category = category;
//        this.dueDate = dueDate;
    }

    public Task(Integer id, String name, String details, String category) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.category = category;
//        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void editTask(String name, String details, String category){
        this.name = name;
        this.details = details;
        this.category = category;
    }

    //    public String getDueDate() {
//        return dueDate;
//    }



}
