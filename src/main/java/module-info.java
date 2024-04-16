module com.example.todoapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.todoapp to javafx.fxml;
    exports com.example.todoapp;
}