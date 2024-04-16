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

    // Getter method for the Title property
    public String getTitle() {
        return title;
    }

    // Getter method for the Description property
    public String getDescription() {
        return description;
    }

    // Getter method for the Due Date property
    public myDOB getDueDate() {
        return dueDate;
    }

    // Getter method for the status property
    public String getStatus() {
        return status;
    }


}
