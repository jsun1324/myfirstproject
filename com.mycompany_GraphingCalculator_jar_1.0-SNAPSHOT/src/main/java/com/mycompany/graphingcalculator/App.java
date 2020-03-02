package com.mycompany.graphingcalculator;

import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
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
        
        //initializing the combo box/equation type chooser
        final ComboBox emailComboBox = new ComboBox();
        emailComboBox.getItems().addAll(
                "y=mx+b",
                "y=ax^2+bx+c",
                "y=ax^3+bx^2+cx",
                "y=ax^4+bx^3+cx^2",
                "y=ax^2",
                "y=asin(x)",
                "y=acos(x)"
        );

        
        
        //Setting window title
        stage.setTitle("Graphing Calculator");
        
        //setting up graphing area
        
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        //creating the chart
        final LineChart<Number, Number> lineChart
                = new LineChart<Number, Number>(xAxis, yAxis);
        //defining graph title
        lineChart.setTitle("Graph of Equation");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        

        //setting up text entry area/text field
        TextField textField = new TextField();
        //setting prompt text
        textField.setPromptText("Enter your variables in order, seperated by a space in this text field.");

        //initializing graph button
        Button graph = new Button("Graph");

        //setting graph button actions
        graph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //check if text area is empty, if not proceed
                if ((textField.getText() != null && !textField.getText().isEmpty())) {
                    //checking if the equation type chooser is set to any equation type
                    //clears previous series
                    //if it is determined that it is a type of equation, the program splits the string entered
                    //in the text entry area and parses them as integers to use as variables in the equation
                    //a for loop then populates the series with each output value from -10 to 10 on intervals of 0.1
                    if (emailComboBox.getValue().equals("y=mx+b")) {
                        series.getData().clear();
                        String[] arrOfStr = textField.getText().split(" ");
                        int a = Integer.parseInt(arrOfStr[0]);
                        int b = Integer.parseInt(arrOfStr[1]);
                        series.setName("y=" + a + "x+" + b);
                        for (double i = -10; i < 10; i = i + 0.1) {
                            series.getData().add(new XYChart.Data(i, a * i + b));
                        }
                        //System.out.println("LIN " + textField.getText());
                    } else if (emailComboBox.getValue().equals("y=ax^2+bx+c")) {
                        series.getData().clear();
                        String[] arrOfStr = textField.getText().split(" ");
                        int a = Integer.parseInt(arrOfStr[0]);
                        int b = Integer.parseInt(arrOfStr[1]);
                        int c = Integer.parseInt(arrOfStr[2]);
                        series.setName("y=" + a + "x^2+" + b + "x+" + c);
                        for (double i = -10; i < 10; i = i + 0.1) {
                            series.getData().add(new XYChart.Data(i, a * Math.pow(i, 2) + b * i + c));
                        }
                        //System.out.println("QUAD " + textField.getText());
                    } else if (emailComboBox.getValue().equals("y=ax^3+bx^2+cx")) {
                        series.getData().clear();
                        String[] arrOfStr = textField.getText().split(" ");
                        int a = Integer.parseInt(arrOfStr[0]);
                        int b = Integer.parseInt(arrOfStr[1]);
                        int c = Integer.parseInt(arrOfStr[2]);
                        series.setName("y=" + a + "x^3+" + b + "x^2+" + c + "x");
                        for (double i = -10; i < 10; i = i + 0.1) {
                            series.getData().add(new XYChart.Data(i, a * Math.pow(i, 3) + b * Math.pow(i, 2) + c * i));
                        }
                        //System.out.println("QUADBUTBIGGER " + textField.getText());
                    } else if (emailComboBox.getValue().equals("y=ax^4+bx^3+cx^2")) {
                        series.getData().clear();
                        String[] arrOfStr = textField.getText().split(" ");
                        int a = Integer.parseInt(arrOfStr[0]);
                        int b = Integer.parseInt(arrOfStr[1]);
                        int c = Integer.parseInt(arrOfStr[2]);
                        series.setName("y=" + a + "x^4+" + b + "x^3+" + c + "x^2");
                        for (double i = -10; i < 10; i = i + 0.1) {
                            series.getData().add(new XYChart.Data(i, a * Math.pow(i, 4) + b * Math.pow(i, 3) + c * Math.pow(i, 2)));
                        }
                        //System.out.println("QUADBUTEVENBIGGER " + textField.getText());
                    } else if (emailComboBox.getValue().equals("y=ax^2")) {
                        series.getData().clear();
                        int a = Integer.parseInt(textField.getText());
                        series.setName("y=" + a + "x^2");
                        for (double i = -10; i < 10; i = i + 0.1) {
                            series.getData().add(new XYChart.Data(i, a*Math.pow(i, 2)));
                        }
                        //System.out.println("POW " + textField.getText());
                    } else if (emailComboBox.getValue().equals("y=asin(x)")) {
                        series.getData().clear();
                        int a = Integer.parseInt(textField.getText());
                        series.setName("y=" + a + "sin(x)");
                        for (double i = -10; i < 10; i = i + 0.1) {
                            series.getData().add(new XYChart.Data(i, a*Math.sin(i)));
                        }
                        //System.out.println("SIN " + textField.getText());
                    } else if (emailComboBox.getValue().equals("y=acos(x)")) {
                        series.getData().clear();
                        int a = Integer.parseInt(textField.getText());
                        series.setName("y=" + a + "cos(x)");
                        for (double i = -10; i < 10; i = i + 0.1) {
                            series.getData().add(new XYChart.Data(i, a*Math.cos(i)));
                        }
                        //System.out.println("COS " + textField.getText());
                    }
                }
            }
        });
        
        //adding data from series to graph
        lineChart.getData().add(series);
        //adding every object to a vbox for formatting
        VBox vbox = new VBox(emailComboBox, textField, graph, lineChart);
        //initializing the main scene and adding the vbox
        Scene scene = new Scene(vbox, 800, 600);

        //setting scene
        stage.setScene(scene);
        //showing scene
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
