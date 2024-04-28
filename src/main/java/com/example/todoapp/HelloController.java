package com.example.todoapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HelloController extends Application {

    @FXML
    private TextField addTitle;

    @FXML
    private TextField addDescription;

    @FXML
    private TextField addDueDate;

    @FXML
    private TextField addStatus;

    @FXML
    private TextField addLocation;

    @FXML
    private TextField addAssignedTo;

    @FXML
    private TextField addForProject;


    @FXML
    private TableView<Task> taskTableView;

    @FXML
    private TableColumn<Task, String> titleColumn;

    @FXML
    private TableColumn<Task, String> descriptionColumn;

    @FXML
    private TableColumn<Task, String> dueDateColumn;

    @FXML
    private TableColumn<Task, String> statusColumn;

    @FXML
    private TableColumn<Task, String> locationColumn;

    @FXML
    private TableColumn<Task, String> AssignedToColumn;

    @FXML
    private TableColumn<Task, String> ForProjectColumn;



    private LocalDate currentDate;


    private ObservableList<Task> taskList;

    @FXML
    protected void initialize() {

        currentDate = LocalDate.now();
        //Creates an empty observable list for tasks.
        taskList = FXCollections.observableArrayList();
        // Initialize columns in the table view
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        AssignedToColumn.setCellValueFactory(new PropertyValueFactory<>("assignedTo"));
        ForProjectColumn.setCellValueFactory(new PropertyValueFactory<>("forProject"));



        // Create an observable list and populate the table view
        //An observable list is allowing the tasks to be added to the table view in real time. It allows for the user to see current real time changes.
        ObservableList<Task> tasks = FXCollections.observableArrayList(generateTasks());
        taskTableView.setItems(tasks);
    }


    //Method called when Add Button is clicked
    @FXML
    protected void onAddButtonClick() {
        //Get input values from text fields.
        String title = addTitle.getText();
        String description = addDescription.getText();
        myDOB dueDate = parseDOB(addDueDate.getText());
        String status = addStatus.getText();
        String location = addLocation.getText();
        String assignedTo = addAssignedTo.getText();
        String forProject = addForProject.getText();

        Task newTask;
        if (location.isEmpty() && assignedTo.isEmpty() && forProject.isEmpty()) {
            // If location, assignedTo, and forProject are empty, then create a task object.
            newTask = new Task(title, description, dueDate, status);

            //Else if assignedTo and forProject are empty, then create a personalTask object.
        } else if(assignedTo.isEmpty() && forProject.isEmpty()) {
            // If location field is not empty, it creates a PersonalTask object
            newTask = new PersonalTask(title, description, dueDate, status, location);
        }

        //else if only location is empty, then a work task is created.
        else {
            newTask = new WorkTask(title, description, dueDate, status, assignedTo, forProject);
        }



      // Add new task to taskList and refresh TableView
        taskList.add(newTask);
        taskTableView.getItems().add(newTask);
        taskTableView.refresh();

        newTask.DisplayDetails();

    }


//Method called when Edit button was clicked.
    @FXML
    protected void onEditButtonClick() {
        Task selectedTask = taskTableView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            // Set the TableView columns editable
            titleColumn.setEditable(true);
            descriptionColumn.setEditable(true);
            dueDateColumn.setEditable(true);
            statusColumn.setEditable(true);

            // Set the TableView to be editable
            taskTableView.setEditable(true);
        } else {
            showAlert(AlertType.WARNING, "No Task Selected", "Please select a task to edit.");
        }
    }

    //Method called when delete button is clicked.
    @FXML
    protected void onDeleteButtonClick() {
        // Gets the selected task
        Task selectedTask = taskTableView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            // If a task is selected, remove it from the TableView
            taskTableView.getItems().remove(selectedTask);
        } else {
            // If no task is selected, show a warning alert
            showAlert(AlertType.WARNING, "No Task Selected", "Please select a task to delete.");
        }
    }

    // Method to display an alert message
    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }


    private List<Task> generateTasks() {
        List<Task> tasks = new ArrayList<>();
        //There are already two tasks generated that populate the table view when the application first launches.
        tasks.add(new Task("Task 1", "Description 1", new myDOB(20,9,2024), "Pending"));
        tasks.add(new Task("Task 2", "Description 2", new myDOB(30,10,2023), "Completed"));
        return tasks;
    }


    private void clearInputFields() {
        addTitle.clear();
        addDescription.clear();
        addDueDate.clear();
        addStatus.clear();
    }

    // Method to parse a date string into a myDOB object
    private myDOB parseDOB(String dobString) {
        // Print the input date of birth string for debugging
        System.out.println("Input DOB string: " + dobString);

        // Split the date of birth string using "/" as delimiter
        String[] parts = dobString.split("/");

        // Extract day, month, and year from the split string parts
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        // Print the parsed day, month, and year for debugging

        // Create and return a new myDOB object with the parsed day, month, and year
        System.out.println("Parsed day: " + day + ", month: " + month + ", year: " + year);
        return new myDOB(day, month, year);
    }

    @Override
    public void start(Stage stage) {

    }

    // Main method for launching the application
    public static void main(String[] args) {
        launch(args);
    }
}
