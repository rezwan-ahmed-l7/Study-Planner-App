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

        VBox nameGroup = new VBox(8);
        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #000000;");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        nameField.setStyle(
                "-fx-background-color: #f8f9fa; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 10;");
        nameGroup.getChildren().addAll(nameLabel, nameField);

        VBox idGroup = new VBox(8);
        Label idLabel = new Label("ID:");
        idLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #000000;");
        TextField idField = new TextField();
        idField.setPromptText("Enter your ID (3 digits)");
        idField.setStyle(
                "-fx-background-color: #f8f9fa; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 10;");
        idGroup.getChildren().addAll(idLabel, idField);

        VBox deptGroup = new VBox(8);
        Label deptLabel = new Label("Department:");
        deptLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #000000;");
        ChoiceBox<String> deptDropdown = new ChoiceBox<>();
        deptDropdown.getItems().addAll("CSE", "BBA", "English");
        deptDropdown.setValue("CSE");
        deptDropdown.setMaxWidth(Double.MAX_VALUE);
        deptDropdown.setStyle(
                "-fx-background-color: #f8f9fa; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 8;");
        deptGroup.getChildren().addAll(deptLabel, deptDropdown);

        Button submitBtn = new Button("Submit");
        submitBtn.setMaxWidth(Double.MAX_VALUE);
        submitBtn.setStyle(
                "-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px; -fx-padding: 12; -fx-background-radius: 8;");

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-size: 13px;");

        submitBtn.setOnAction(e -> {
            String id = idField.getText();
            if (nameField.getText().isEmpty() || !id.matches("\\d{3}")) {
                errorLabel.setText("Error: Name required & ID must be 3 digits!");
            } else {
                this.studentName = nameField.getText();
                this.department = deptDropdown.getValue();
                showPlannerScene();
            }
        });

        root.getChildren().addAll(title, subtitle, line, nameGroup, idGroup, deptGroup, submitBtn, errorLabel);
        primaryStage.setScene(new Scene(root, WIN_WIDTH, WIN_HEIGHT));
        primaryStage.show();
    }

    private void showPlannerScene() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: white;");

        Label welcomeLabel = new Label("Welcome, " + studentName);
        welcomeLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #000000;");

        Label deptLabel = new Label("Department: " + department);
        deptLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #20818e;");

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
        taskDropdown.setStyle(
                "-fx-background-color: #f8f9fa; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 8;");

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

    private void addTaskRow(String taskName) {
        HBox row = new HBox();
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(15, 20, 15, 20));
        row.setStyle(
                "-fx-background-color: white; -fx-border-color: #e9ecef; -fx-border-radius: 10; -fx-background-radius: 10;");

        DropShadow rowShadow = new DropShadow();
        rowShadow.setRadius(5);
        rowShadow.setOffsetY(2);
        rowShadow.setColor(Color.rgb(0, 0, 0, 0.05));
        row.setEffect(rowShadow);

        Label taskLabel = new Label(taskName);
        taskLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #000000; -fx-font-weight: 500;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button completeBtn = new Button("Complete");
        completeBtn.setStyle(
                "-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 18; -fx-background-radius: 6;");

        completeBtn.setOnAction(e -> taskContainer.getChildren().remove(row));

        row.getChildren().addAll(taskLabel, spacer, completeBtn);
        taskContainer.getChildren().add(row);
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
