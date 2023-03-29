package com.notes.notes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class timetableController {

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
        stage.show();
    }

    public void initialize() {

    }

}
