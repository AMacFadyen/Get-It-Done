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
    private int id;
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

    public Task(int id, String name, String details, String category) {
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

    //    public String getDueDate() {
//        return dueDate;
//    }

    public boolean save(DBHelper dbHelper){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TASKS_COLUMN_NAME, this.name);
        cv.put(TASKS_COLUMN_DETAILS, this.details);
        cv.put(TASKS_COLUMN_CATEGORY, this.category);
        db.insert(TASKS_TABLE_NAME, null, cv);

        return true;
    }

}
