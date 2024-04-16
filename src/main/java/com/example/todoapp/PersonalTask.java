package com.example.todoapp;

public class PersonalTask extends Task{
    private myDOB reminder;
    private String location;
    private boolean recurring;

    PersonalTask(String title, String description, myDOB dueDate, String status) {
        super(title, description, dueDate, status);
    }

    // Getter and Setter for reminder
    public myDOB getReminder() {
        return reminder;
    }

    public void setReminder(myDOB reminder) {
        this.reminder = reminder;
    }

    // Getter and Setter for location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getter and Setter for recurring
    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

}
