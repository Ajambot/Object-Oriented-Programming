/*
Name: Martin Morales Arana
Student ID: 1172178
Lab 11, Q1

The program implements a JavaFx application with a flag and two lines of different colors
that resize and reposition according to size of window.
 */
package com.example.q1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Morales_Martin_Lab11_Q1 extends Application {
    @Override
    public void start(Stage stage){
        Pane pane = new Pane();
        Image flag = new Image("C:\\Users\\marti\\OneDrive\\Documentos\\OneNote Notebooks\\COMP 2477 Object Oriented Programming\\Labs\\Lab 11\\Q1\\src\\main\\resources\\com\\example\\q1\\ca.gif");
        ImageView img = new ImageView(flag);
        img.fitHeightProperty().bind(stage.heightProperty().divide(5));
        img.fitWidthProperty().bind(stage.widthProperty().divide(2.5));
        img.setX(0);
        img.setY(0);
        Line redLine = new Line();
        /*redLine.setStartX(stage.getWidth()/2);
        redLine.setStartY(0);
        redLine.setEndX(stage.getWidth()/2);
        redLine.setEndY(stage.getHeight());*/
        redLine.setStrokeWidth(1);
        redLine.startXProperty().bind(stage.widthProperty().divide(2));
        redLine.startYProperty().bind(stage.heightProperty().multiply(0));
        redLine.endXProperty().bind(stage.widthProperty().divide(2));
        redLine.endYProperty().bind(stage.heightProperty());
        redLine.setStroke(Color.RED);
        Line blueLine = new Line();
        blueLine.startXProperty().bind(stage.widthProperty().multiply(0));
        blueLine.startYProperty().bind(stage.heightProperty().divide(2));
        blueLine.endXProperty().bind(stage.widthProperty());
        blueLine.endYProperty().bind(stage.heightProperty().divide(2));
        /*blueLine.setStartX(0);
        blueLine.setStartY(stage.getHeight()/2);
        blueLine.setEndX(stage.getWidth());
        blueLine.setEndY(stage.getHeight()/2);*/
        blueLine.setStroke(Color.BLUE);
        blueLine.setStrokeWidth(1);
        pane.getChildren().addAll(img, redLine, blueLine);
        Scene scene = new Scene(pane, 320, 240);
        stage.setTitle("In Class Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}