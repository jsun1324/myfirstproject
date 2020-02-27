package com.mycompany.graphingcalculator;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//import javax.script.ScriptEngineManager;
//import javax.script.ScriptEngine;
//import javax.script.ScriptException;

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
            "jacob.smith@example.com",
            "isabella.johnson@example.com",
            "ethan.williams@example.com",
            "emma.jones@example.com",
            "michael.brown@example.com"  
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
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Graph of Equation");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        
        //populating the series with data
        
        for (int i = -100; i < 100; i++) {
            series.getData().add(new XYChart.Data(i, a*Math.pow(i, powa)+b*Math.pow(i, powb)+c*Math.pow(i, powc)));
            
        }
        
        Scene scene  = new Scene(root,800,600);
        lineChart.getData().add(series);
        root.getChildren().add(lineChart);
        //SWITCH FROM GROUP TO VBOX TO FIX LAYOUT
       
        stage.setScene(scene);
        stage.show();
    }
    

    public static void main(String[] args) {
        launch();
    }
//    public static void script(String[] args) throws ScriptException {
//    ScriptEngineManager mgr = new ScriptEngineManager();
//    ScriptEngine engine = mgr.getEngineByName("JavaScript");
//    String foo = "40+2";
//    System.out.println(engine.eval(foo));
//    } 

}
