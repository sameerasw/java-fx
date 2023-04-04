package com.notes.notes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class compilerController implements Initializable {

    private final String[] compilers = {"Python","Java","JavaScript","HTML","PHP"};

    @FXML
    private Button exit;

    @FXML
    private WebView intranetView;

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    void exitClick(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    private ChoiceBox<String> lang;

    @FXML
    private Button refresh;

    @FXML
    void refreshClick(ActionEvent event) {
        WebEngine webEngine = intranetView.getEngine();
        webEngine.reload();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WebEngine webEngine = intranetView.getEngine();
        webEngine.load("https://www.programiz.com/python-programming/online-compiler/");
        lang.getItems().clear();
        lang.getItems().addAll(compilers);
        lang.setValue("Python");
        lang.setOnAction(event -> {
            String selected = lang.getValue();
            lang.setValue(selected);
            switch (selected) {
                case "Python" -> webEngine.load("https://www.programiz.com/python-programming/online-compiler/");
                case "Java" -> webEngine.load("https://www.programiz.com/java-programming/online-compiler/");
                case "JavaScript" ->
                        webEngine.load("https://www.programiz.com/javascript/online-compiler/");
                case "HTML" -> webEngine.load("https://www.programiz.com/html/online-compiler/");
                case "PHP" -> webEngine.load("https://www.programiz.com/php/online-compiler/");
            }
        });
    }

}
