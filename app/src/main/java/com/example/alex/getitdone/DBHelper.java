package com.example.alex.getitdone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static android.os.Build.VERSION_CODES.O;

/**
 * Created by Alex on 10/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "tasks.db";
    public static final String TASKS_TABLE_NAME = "tasks";
    public static final String TASKS_COLUMN_ID = "id";
    public static final String TASKS_COLUMN_NAME = "name";
    public static final String TASKS_COLUMN_DETAILS = "details";
    public static final String TASKS_COLUMN_CATEGORY = "category";
//    public static final String TASKS_COLUMN_DUE_DATE = "dueDate";

    public DBHelper(Context context) {super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TASKS_TABLE_NAME + " (id INTEGER primary key autoincrement, name TEXT, details TEXT, category TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TASKS_TABLE_NAME);
        onCreate(db);
    }

    public boolean save(String name, String details, String category){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TASKS_COLUMN_NAME, name);
        cv.put(TASKS_COLUMN_DETAILS, details);
        cv.put(TASKS_COLUMN_CATEGORY, category);
        db.insert(TASKS_TABLE_NAME, null, cv);

        return true;
    }

    public ArrayList<Task> all(){
        ArrayList<Task> tasks = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TASKS_TABLE_NAME, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(TASKS_COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(TASKS_COLUMN_NAME));
            String details = cursor.getString(cursor.getColumnIndex(TASKS_COLUMN_DETAILS));
            String category = cursor.getString(cursor.getColumnIndex(TASKS_COLUMN_CATEGORY));
            Task task = new Task(id, name, details, category);
            tasks.add(task);
//            String dueDate = cursor.getString(cursor.getColumnIndex(TASKS_COLUMN_DUE_DATE));
        }
        cursor.close();
        return tasks;
    }

    public void delete(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = " id=?";
        String[] values = {id.toString()};
        db.delete(TASKS_TABLE_NAME, selection, values);
    }



}
