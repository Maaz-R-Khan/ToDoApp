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

    // Method to display details about the task.
    public void DisplayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Due Date: " + dueDate);
        System.out.println("Status: " + status);
        System.out.println("This is a general Task");
    }

    //Overloaded method to display details about the task including additional information.
    public void DisplayDetails(boolean IncludeAdditonalInfo) {
       DisplayDetails();
        DisplayDetails(); // Call the original DisplayDetails method
    }


}
