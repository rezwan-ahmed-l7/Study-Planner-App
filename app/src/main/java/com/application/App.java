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

        VBox selectBox = new VBox(8);
        Label selectLabel = new Label("Select Task:");
        selectLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #000000;");

        ChoiceBox<String> taskDropdown = new ChoiceBox<>();
        List<String> options = getSuggestionsForDept(department);
        taskDropdown.getItems().addAll(options);
        taskDropdown.setValue(options.get(0));
        taskDropdown.setMaxWidth(Double.MAX_VALUE);
        taskDropdown.setStyle("-fx-background-color: #f8f9fa; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 8;");

                Button addTaskBtn = new Button("+ Add Task");
        addTaskBtn.setMaxWidth(Double.MAX_VALUE);
        addTaskBtn.setStyle(
                "-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px; -fx-padding: 12; -fx-background-radius: 8;");

        Label limitErrorLabel = new Label();
        limitErrorLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-size: 13px; -fx-font-weight: bold;");

        selectBox.getChildren().addAll(selectLabel, taskDropdown, addTaskBtn, limitErrorLabel);

        taskContainer = new VBox(15);
        taskContainer.setPadding(new Insets(10, 0, 0, 0));

        addTaskBtn.setOnAction(e -> {
            if (taskContainer.getChildren().size() < 5) {
                limitErrorLabel.setText("");
                String selectedTask = taskDropdown.getValue();
                addTaskRow(selectedTask);
            } else {
                limitErrorLabel.setText("You can only add 5 tasks !");
            }
        });

        root.getChildren().addAll(welcomeLabel, deptLabel, line, selectBox, taskContainer);
        primaryStage.setScene(new Scene(root, WIN_WIDTH, WIN_HEIGHT));
        }

        private List<String> getSuggestionsForDept(String dept) {
        if (dept.equals("CSE"))
            return Arrays.asList("Practice problem solving", "Complete DSA Assignment", "Practice OOP JAVA",
                    "Work on SDP Project", "Prepare for exams");
        if (dept.equals("BBA"))
            return Arrays.asList("Work on Management skills", "Practice Accounting Maths", "Improve Presentation",
                    "Complete Statistics Assignment", "Improve Communication skills");
        if (dept.equals("English"))
            return Arrays.asList("Practice public speaking", "Improve grammar & vocabulary", "Creative Writing",
                    "Watch Practicing TED Talks", "Literature Review");
        return Arrays.asList("General Study");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
