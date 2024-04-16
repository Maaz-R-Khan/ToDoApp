package com.example.todoapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class TaskListViewController {

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
    private Button editButton;

    @FXML
    private Button deleteButton;


    // Method to populate the TableView with tasks
    public void initialize(List<Task> tasks) {
        // Set the items of the TableView to the provided list of tasks
        taskTableView.getItems().addAll(tasks);
    }

    // Event handler for the Edit button
    @FXML
    private void onEditButtonClick() {
        Task selectedTask = taskTableView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            // Implement logic to handle editing the selected task
            // For example, open a dialog to edit the task details
        }
    }

    // Event handler for the Delete button
    @FXML
    private void onDeleteButtonClick() {
        Task selectedTask = taskTableView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            // Remove the selected task from the TableView
            taskTableView.getItems().remove(selectedTask);
        }
    }

}
