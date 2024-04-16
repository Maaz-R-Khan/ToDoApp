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
        currentDate = LocalDate.now();
        List<Task> tasks = generateTasks();
        taskTableView.getItems().addAll(tasks);
    }

    @FXML
    protected void onAddButtonClick() {
        String title = addTitle.getText();
        String description = addDescription.getText();
        myDOB dueDate = parseDOB(addDueDate.getText());
        String status = addStatus.getText();
        Task newTask = new Task(title, description, dueDate, status);
        taskTableView.getItems().add(newTask);
        clearInputFields();
    }

    @FXML
    protected void onEditButtonClick() {
        Task selectedTask = taskTableView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            showAlert(AlertType.INFORMATION, "Edit", "Editing task: " +  "Edit" + selectedTask.title);
        } else {
            showAlert(AlertType.WARNING, "No Task Selected", "Please select a task to edit.");
        }
    }

    @FXML
    protected void onDeleteButtonClick() {
      
        Task selectedTask = taskTableView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
           
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
        System.out.println("Input DOB string: " + dobString); 
        String[] parts = dobString.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        System.out.println("Parsed day: " + day + ", month: " + month + ", year: " + year); 
        return new myDOB(day, month, year);
    }

    @Override
    public void start(Stage stage) {
   
    }

   
    public static void main(String[] args) {
        launch(args);
    }
}
