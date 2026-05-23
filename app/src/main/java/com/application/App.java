package com.application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.util.Arrays;
import java.util.List;

public class App extends Application {

    private Stage primaryStage;
    private String studentName;
    private String department;
    private VBox taskContainer;

    private final double WIN_WIDTH = 750;
    private final double WIN_HEIGHT = 750;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Department Based Study Planner");
        this.primaryStage.setResizable(false);
        showRegistrationScene();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
