module com.notes.notes {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.desktop;


    opens com.notes.notes to javafx.fxml;
    exports com.notes.notes;
}