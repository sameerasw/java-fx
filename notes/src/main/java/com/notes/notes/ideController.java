package com.notes.notes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.util.Objects;
import java.util.ResourceBundle;

public class ideController implements Initializable {

    @FXML
    private Button ideBack;

    @FXML
    private WebView ideView;

    @FXML
    private ChoiceBox<String> langSelect;

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    void ideBackClick(ActionEvent event) throws IOException {
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

    private final String[] langs = {"Python","Java","Java Script","SQL"};
    WebEngine webEngine;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        langSelect.setValue("Python");
        langSelect.getItems().clear();
        langSelect.getItems().addAll(langs);
        langSelect.setOnAction(this::langSelect);
    }

    private void langSelect(ActionEvent actionEvent) {
        String module = langSelect.getValue();
        Stage stage = (Stage) langSelect.getScene().getWindow();
        stage.setTitle(langSelect.getValue());
        WebEngine webEngine = ideView.getEngine();
        if (Objects.equals(module, "Python")) {
            webEngine.load("https://www.programiz.com/python-programming/online-compiler/");
        } else if (Objects.equals(module, "Java")) {
            webEngine.load("https://www.programiz.com/java-programming/online-compiler/");
        } else if (Objects.equals(module, "Java Script")) {
            webEngine.load("https://www.programiz.com/javascript/online-compiler/");
        } else if (Objects.equals(module, "SQL")) {
            webEngine.load("https://www.programiz.com/sql/online-compiler/");
        }
    }
}
