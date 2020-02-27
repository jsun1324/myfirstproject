package com.mycompany.javafxtestproject;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

//        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        var scene = new Scene(new StackPane(label), 640, 480);
//        stage.setScene(scene);
//        stage.show();
        final ComboBox emailComboBox = new ComboBox();
        emailComboBox.getItems().addAll(
            "jacob.smith@example.com",
            "isabella.johnson@example.com",
            "ethan.williams@example.com",
            "emma.jones@example.com",
            "michael.brown@example.com"  
        );
        
        
        Group root = new Group();
        root.getChildren().add(emailComboBox);
        
        stage.setTitle("ComboBoxSample");
        Scene scene = new Scene(root, 450, 250);
        
        
        
        stage.setScene(scene);
        stage.show();
        
        
    }

    public static void main(String[] args) {
        launch();
        
    }

}