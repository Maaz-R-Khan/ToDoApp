package com.example.todoapp;

public class WorkTask extends Task {
    private String assignedTo;

    private String forProject;

    //Parametric constructor
   public WorkTask(String title, String description, myDOB dueDate, String status, String assignedTo, String forProject) {
        super(title, description, dueDate, status);
        this.assignedTo = assignedTo;
        this.forProject = forProject;
    }

    //Getter method for AssignedTo
    public String getAssignedTo() {
        return assignedTo;
    }

    //Setter method for AssignedTo
    public void setAssignedTo(String assignedTo) {
         this.assignedTo = assignedTo;
    }

    //Getter method for ForProject
    public String getForProject() {
        return forProject;
    }

    //Setter method for AssignedTo
    public void setForProject(String forProject) {
        this.forProject = forProject;
    }


    // Method to display details about the task.
    //This method is also an override from the display details method from the task class.
    //It additionally also displays the assignedTo and forProject attribute and identifies that it is a Work task.
   @Override
    public void DisplayDetails() {
        super.DisplayDetails();
        System.out.println("assignedTo: " + assignedTo);
        System.out.println("forProject: " + forProject);
       System.out.println("This is a Work Task.");
  }



}
