package com.mycompany.graphingcalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
//        testing
        final ComboBox emailComboBox = new ComboBox();
        emailComboBox.getItems().addAll(
                "y=mx+b",
                "y=ax^2+bx+c",
                "y=x^2",
                "y=sin(x)",
                "y=cos(x)"
        );

        Group root = new Group();
        root.getChildren().add(emailComboBox);

        int a = 100;
        int b = 100;
        int c = 100;
        int powa = 2;
        int powb = 1;
        int powc = 0;
        stage.setTitle("Graphing Calculator");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        //creating the chart
        final LineChart<Number, Number> lineChart
                = new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Graph of Equation");
        //defining a series
        XYChart.Series series = new XYChart.Series();

        //populating the series with data
        for (int i = -100; i < 100; i++) {
            series.getData().add(new XYChart.Data(i, a * Math.pow(i, powa) + b * Math.pow(i, powb) + c * Math.pow(i, powc)));

        }
        
        
        
        TextField textField = new TextField ();

        Button graph = new Button("Graph");

        graph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if ((textField.getText() != null && !textField.getText().isEmpty())) {
                    if(emailComboBox.getValue().equals("y=mx+b")){
                        System.out.println("LIN " + textField.getText());
                    }else if(emailComboBox.getValue().equals("y=ax^2+bx+c")){
                        System.out.println("QUAD " + textField.getText());
                    }else if(emailComboBox.getValue().equals("y=x^2")){
                        System.out.println("POW " + textField.getText());
                    }else if(emailComboBox.getValue().equals("y=sin(x)")){
                        System.out.println("SIN " + textField.getText());
                    }else if(emailComboBox.getValue().equals("y=cos(x)")){
                        System.out.println("COS " + textField.getText());
                    }
                }
            }
        });

        VBox vbox = new VBox(emailComboBox, textField, graph, lineChart);
        Scene scene = new Scene(vbox, 800, 600);

        //SWITCH FROM GROUP TO VBOX TO FIX LAYOUT
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
