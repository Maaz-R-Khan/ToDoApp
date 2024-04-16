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
    private TableView<Task> taskTableView;

    @FXML
    private TableColumn<Task, String> titleColumn;

    @FXML
    private TableColumn<Task, String> descriptionColumn;

    @FXML
    private TableColumn<Task, String> dueDateColumn;

    @FXML
    private TableColumn<Task, String> statusColumn;

    private LocalDate currentDate;


    private ObservableList<Task> taskList;

    @FXML
    protected void initialize() {

        // List<Task> tasks = generateTasks();
        // taskTableView.getItems().addAll(tasks);
        currentDate = LocalDate.now();

        taskList = FXCollections.observableArrayList();
        // Initialize columns
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Create an observable list and populate the table view
        //An observable list is allowing
        ObservableList<Task> tasks = FXCollections.observableArrayList(generateTasks());
        taskTableView.setItems(tasks);
    }


    @FXML
    protected void onAddButtonClick() {
        String title = addTitle.getText();
        String description = addDescription.getText();
        myDOB dueDate = parseDOB(addDueDate.getText());
        String status = addStatus.getText();
        Task newTask = new Task(title, description, dueDate, status);
      //  PersonalTask newPersonalTask = new PersonalTask(title, description, dueDate, status, reminder, );
      //  ObservableList<String> tasks = FXCollections.observableArrayList();
        taskList.add(newTask);
        taskTableView.getItems().add(newTask);
      //  taskList.add(newTask);
        taskTableView.refresh();

        // clearInputFields();
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
        // Get the selected task
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

    // Main method for launching the application
    public static void main(String[] args) {
        launch(args);
    }
}
