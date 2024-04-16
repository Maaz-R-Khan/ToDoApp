package com.example.todoapp;
import java.time.LocalDate;

public class Task {

    protected String title;
    protected String description;
    protected myDOB dueDate;
    protected String status;

    //Parametric Constructor
    Task(String title, String description, myDOB dueDate, String status) {
        this.title = title;
        this.description = description;
        this.dueDate = new myDOB(dueDate);
        this.status = status;
    }


}
