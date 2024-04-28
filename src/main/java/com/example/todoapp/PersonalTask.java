package com.example.todoapp;

public class PersonalTask extends Task{

    private String location;


    //Parametric constructor
    PersonalTask(String title, String description, myDOB dueDate, String status, String location ) {
        super(title, description, dueDate, status);
        this.location = location;

    }


    // Getter method for location
    public String getLocation() {
        return location;
    }

    //Setter method for location
    public void setLocation(String location) {
        this.location = location;
    }


    // Method to display details about the task.
    //This method is also an override from the display details method from the task class.
    //It additionally also displays the location attribute and identifies that this is a personal task.
    @Override
    public void DisplayDetails() {
        super.DisplayDetails();
        System.out.println("Location: " + location);
        System.out.println("This task is a Personal Task");
    }

}
