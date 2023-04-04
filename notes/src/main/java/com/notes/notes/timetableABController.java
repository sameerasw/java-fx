package com.notes.notes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class timetableABController {

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private Button timeTable;
    @FXML
    private Button ttBack;

    @FXML
    void ttBackClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        root = loader.load();
        HelloController helloController = loader.getController();
        URL url = new URL("https://sameerasw.notion.site/IIT-InfoSchol-a4d4da8520174a36958c3457bcf23f3c/");
        helloController.initialize(url, null);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Study Portal");
        stage.show();
    }

    @FXML
    private Button ttAB;

    @FXML
    private Button ttCD;

    @FXML
    private Text ttTitle;

    @FXML
    void ttABClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("timetableAB.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Time Table - Group A & B");
        stage.show();
        ttTitle.setText("Time Table - Group A & B");
    }

    @FXML
    void ttCDClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("timetableCD.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Time Table - Group C & D");
        stage.show();
        ttTitle.setText("Time Table - Group C & D");
    }


    public void initialize() throws InterruptedException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Timetable");
        alert.setHeaderText("Timetable might not be accurate");
        alert.setContentText("Because it's being changed frequently");
        alert.show();
    }

}
