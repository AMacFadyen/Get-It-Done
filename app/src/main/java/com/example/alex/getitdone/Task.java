package com.example.alex.getitdone;

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


}
