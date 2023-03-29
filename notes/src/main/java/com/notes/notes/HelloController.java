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
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.scene.web.WebView;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private WebView webView;

    @FXML
    private ChoiceBox<String> courseSelect;

    private final String[] courses = {"IIT", "UoW"};

    @FXML
    private ChoiceBox<String> moduleSelect;

    @FXML
    private Button timeTable;

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    void timeTableClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("timetable.fxml"));
        root = loader.load();
        timetableController timetableController = loader.getController();
        timetableController.initialize();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Button intranet;

    @FXML
    void intranetClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("intranet.fxml"));
        root = loader.load();
        intranetController intranetController = loader.getController();
        URL url = new URL("https://in.iit.ac.lk/");
        intranetController.initialize(url, null);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private String[] uowModules = {"Software Development 1 - Programming","Software Development 1 - Design","Mathematics in Computing"};
    private String[] iitModules = {"OOP","OOP Design","Web Development","Databases","Introduction to QA"};
    WebEngine webEngine;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courseSelect.getItems().addAll(courses);
        courseSelect.setOnAction(this::courseSelect);
        moduleSelect.setOnAction(this::moduleSelect);
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://sameerasw.notion.site/IIT-InfoSchol-a4d4da8520174a36958c3457bcf23f3c");
    }

    public void courseSelect(ActionEvent event) {
        String course = courseSelect.getValue();
        Stage stage = (Stage) courseSelect.getScene().getWindow();
        stage.setTitle(course);
        Scene scene = courseSelect.getScene();
        if (Objects.equals(course, "UoW")) {
            moduleSelect.getItems().clear();
            moduleSelect.getItems().addAll(uowModules);
        } else {
            moduleSelect.getItems().clear();
            moduleSelect.getItems().addAll(iitModules);
        }
        return;
    }

    public void moduleSelect(ActionEvent event) {
        String module = moduleSelect.getValue();
        String course = courseSelect.getValue();
        Stage stage = (Stage) moduleSelect.getScene().getWindow();
        stage.setTitle(course + " > " + module);
        WebEngine webEngine = webView.getEngine();
        if (Objects.equals(module, "Software Development 1 - Programming")) {
            webEngine.load("https://sameerasw.notion.site/353f996c99984c21abd5ba2147351bde?v=f0ae227e6c0341d28f07a5b777a8b8f5");
        } else if (Objects.equals(module, "Software Development 1 - Design")) {
            webEngine.load("https://sameerasw.notion.site/c59a301949f14fa6808fc869c4ac3345?v=1494119755b14fdab902aba20a69b58a");
        } else if (Objects.equals(module, "Mathematics in Computing")) {
            webEngine.load("https://sameerasw.notion.site/eba4d7297b95494bbd70ceaf9d136668?v=2b972c1d66f7463ba05ed0e2a81680a3");
        } else if (Objects.equals(module, "OOP")) {
            webEngine.load("https://sameerasw.notion.site/Introduction-to-Programming-IT1406-950820572a014a5a84d1c51ce80f8626");
        } else if (Objects.equals(module, "OOP Design")) {
            webEngine.load("https://sameerasw.notion.site/14677a9335274ee78f3b1a7e0be9d0e5?v=7a0b1ed597b546319d70cac316f8bc0d");
        } else if (Objects.equals(module, "Web Development")) {
            webEngine.load("https://sameerasw.notion.site/Web-Development-9143cf6e23b6469aa48260851f7b8984");
        } else if (Objects.equals(module, "Databases")) {
            webEngine.load("https://sameerasw.notion.site/75ec7655e54b4bb5acd296a24fa10ce3?v=0e4fe54237ae48ddae6d1ea8d49f9022");
        } else if (Objects.equals(module, "Introduction to QA")) {
            webEngine.load("https://sameerasw.notion.site/Introduction-to-QA-8ace4dadc0e243d8bd9b200d62b4d622");
        }
    }

}
