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
    
    private void showRegistrationScene() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: white;");

        Image icon = new Image("StudyPlanner.png");
        this.primaryStage.getIcons().add(icon);

        Label title = new Label("Department Based Study Planner");
        title.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        Label subtitle = new Label("Student Registration");
        subtitle.setStyle("-fx-font-size: 20px; -fx-text-fill: #2e7e8b;");

        Line line = new Line(0, 0, WIN_WIDTH - 60, 0);
        line.setStroke(Color.web("#ecf0f1"));


    public static void main(String[] args) {
        launch(args);
    }
}
