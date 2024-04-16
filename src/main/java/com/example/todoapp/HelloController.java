package com.example.todoapp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<Task> taskTableView;

    private LocalDate currentDate;

    @FXML
    protected void initialize() {
        // Initialize the current date
        currentDate = LocalDate.now();
        // Generate initial tasks
        List<Task> tasks = generateTasks();
        // Add initial tasks to the TableView
        taskTableView.getItems().addAll(tasks);
    }

    @FXML
    protected void onAddButtonClick() {
        // Get input values
        String title = addTitle.getText();
        String description = addDescription.getText();
        myDOB dueDate = parseDOB(addDueDate.getText());
        String status = addStatus.getText();
        // Create a new task
        Task newTask = new Task(title, description, dueDate, status);
        // Add the new task to the TableView
        taskTableView.getItems().add(newTask);
        // Clear input fields
        clearInputFields();
    }

    @FXML
    protected void onEditButtonClick() {
        // Get the selected task
        Task selectedTask = taskTableView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            // Implement logic to handle editing the selected task
            showAlert(AlertType.INFORMATION, "Edit", "Editing task: " +  "Edit" + selectedTask.title);
        } else {
            showAlert(AlertType.WARNING, "No Task Selected", "Please select a task to edit.");
        }
    }

    @FXML
    protected void onDeleteButtonClick() {
        // Get the selected task
        Task selectedTask = taskTableView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            // Remove the selected task from the TableView
            taskTableView.getItems().remove(selectedTask);
        } else {
            showAlert(AlertType.WARNING, "No Task Selected", "Please select a task to delete.");
        }
    }

    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private List<Task> generateTasks() {
        List<Task> tasks = new ArrayList<>();
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

    private myDOB parseDOB(String dobString) {
        // Implement the logic to parse the due date string into a myDOB object
        // For example, split the string and extract day, month, and year, then create a myDOB object
        System.out.println("Input DOB string: " + dobString); // Debug output
        String[] parts = dobString.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        System.out.println("Parsed day: " + day + ", month: " + month + ", year: " + year); // Debug output
        return new myDOB(day, month, year);
    }

    @Override
    public void start(Stage stage) {
        // No need to implement for this approach
    }

    // Main method for launching the application
    public static void main(String[] args) {
        launch(args);
    }
}
