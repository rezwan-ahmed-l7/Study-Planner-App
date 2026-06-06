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
import javafx.scene.image.ImageView;
import java.util.Arrays;
import java.util.List;

public class App extends Application {

    private Stage primaryStage;
    private String studentName;
    private String department;
    private VBox taskContainer;
    private Label limitErrorLabel;

    private final double WIN_WIDTH = 800;
    private final double WIN_HEIGHT = 830;

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
        root.setStyle("-fx-background-color: #f5f6fa;");

        Image icon = new Image("StudyPlanner.png");
        this.primaryStage.getIcons().add(icon);

        HBox headerBox = new HBox();
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.setPadding(new Insets(0, 10, 0, 0));

        VBox titleContainer = new VBox(5);
        Label title = new Label("Department Based Study Planner");
        title.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        Label subtitle = new Label("Student Registration");
        subtitle.setStyle("-fx-font-size: 28px; -fx-text-fill: #2e7e8b;");
        titleContainer.getChildren().addAll(title, subtitle);

        Region headerSpacer = new Region();
        HBox.setHgrow(headerSpacer, Priority.ALWAYS);

        ImageView registrationImageView = new ImageView(icon);
        registrationImageView.setFitWidth(100);
        registrationImageView.setPreserveRatio(true);

        headerBox.getChildren().addAll(titleContainer, headerSpacer, registrationImageView);

        Line line = new Line(0, 0, WIN_WIDTH - 60, 0);
        line.setStroke(Color.web("#ecf0f1"));

        VBox nameGroup = new VBox(8);
        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: #000000;");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        nameField.setStyle(
                "-fx-background-color: #f8f9fa; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 12; -fx-font-size: 15px;");
        nameGroup.getChildren().addAll(nameLabel, nameField);

        VBox idGroup = new VBox(8);
        Label idLabel = new Label("ID:");
        idLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: #000000;");
        TextField idField = new TextField();
        idField.setPromptText("Enter your ID (3 digits)");
        idField.setStyle(
                "-fx-background-color: #f8f9fa; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 12; -fx-font-size: 15px;");
        idGroup.getChildren().addAll(idLabel, idField);

        VBox deptGroup = new VBox(8);
        Label deptLabel = new Label("Department:");
        deptLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: #000000;");

        ComboBox<String> deptDropdown = new ComboBox<>();
        deptDropdown.getItems().addAll("CSE", "BBA", "English");
        deptDropdown.setValue("CSE");
        deptDropdown.setMaxWidth(Double.MAX_VALUE);
        deptDropdown.setStyle(
                "-fx-background-color: #ffffff; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 12; -fx-font-size: 16px;");

        deptGroup.getChildren().addAll(deptLabel, deptDropdown);

        Button submitBtn = new Button("Submit");
        submitBtn.setMaxWidth(Double.MAX_VALUE);
        submitBtn.setStyle(
                "-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px; -fx-padding: 12; -fx-background-radius: 8;");

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-weight: bold; -fx-font-size: 16px;");

        VBox suggestionBox = new VBox(10);
        suggestionBox.setPadding(new Insets(15));
        suggestionBox.setAlignment(Pos.CENTER);
        suggestionBox.setStyle(
                "-fx-background-color: #ffffff; -fx-background-radius: 10; -fx-border-color: #ddd; -fx-border-radius: 10;");

        Label suggestionTitle = new Label("Start Small But Start Today.");
        suggestionTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 16px; -fx-text-fill: #2f3542;");

        Label quoteText = new Label();
        quoteText.setWrapText(true);
        quoteText.setStyle(
                "-fx-font-style: italic; -fx-font-size: 15px; -fx-text-fill: #24282e; -fx-text-alignment: center;");
        suggestionBox.getChildren().addAll(suggestionTitle, quoteText);

        updateQuote(deptDropdown.getValue(), quoteText);
        deptDropdown.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateQuote(newValue, quoteText);
        });

        submitBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            String id = idField.getText();

            if (name.isEmpty() || name.matches(".*\\d.*")) {
                errorLabel.setText("Error: Name must contain only letters (no numbers)!");
            } 
            else if (!id.matches("\\d{3}")) {
                errorLabel.setText("Error: Name required & ID must be 3 digits!");
            } 
            else {
                this.studentName = name;
                this.department = deptDropdown.getValue();
                showPlannerScene();
            }
        });

        root.getChildren().addAll(headerBox, line, nameGroup, idGroup, deptGroup, submitBtn, errorLabel,
                suggestionBox);
        primaryStage.setScene(new Scene(root, WIN_WIDTH, WIN_HEIGHT));
        primaryStage.show();
    }

    private void updateQuote(String dept, Label quoteLabel) {

        if ("CSE".equals(dept)) {
            quoteLabel.setText("\"Tip: Build a habit of coding at least 1 hour daily !\"");
        }

        else if ("BBA".equals(dept)) {
            quoteLabel.setText("\"Tip: Focus on communication and presentation skills !\"");
        }

        else if ("English".equals(dept)) {
            quoteLabel.setText("\"Tips: Read an article or a book chapter today !.\"");
        }

        else {
            quoteLabel.setText("\"The secret of getting ahead is getting started.\"");
        }
    }

    private void showPlannerScene() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f5f6fa;");

        HBox headerBox = new HBox();
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.setPadding(new Insets(0, 10, 0, 0));

        VBox titleContainer = new VBox(5);
        Label welcomeLabel = new Label("Welcome, " + studentName);
        welcomeLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: #000000;");
        Label deptLabel = new Label("Department: " + department);
        deptLabel.setStyle("-fx-font-size: 28px; -fx-text-fill: #20818e;");
        titleContainer.getChildren().addAll(welcomeLabel, deptLabel);

        Region headerSpacer = new Region();
        HBox.setHgrow(headerSpacer, Priority.ALWAYS);

        Image icon = new Image("StudyPlanner.png");
        ImageView plannerImageView = new ImageView(icon);
        plannerImageView.setFitWidth(100);
        plannerImageView.setPreserveRatio(true);

        headerBox.getChildren().addAll(titleContainer, headerSpacer, plannerImageView);

        Line line = new Line(0, 0, WIN_WIDTH - 60, 0);
        line.setStroke(Color.web("#ecf0f1"));

        VBox selectBox = new VBox(8);
        Label selectLabel = new Label("Select Task or Write Task:");
        selectLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 15px; -fx-text-fill: #000000;");

        ComboBox<String> taskDropdown = new ComboBox<>();
        List<String> options = getSuggestionsForDept(department);
        taskDropdown.getItems().addAll(options);
        taskDropdown.setValue(options.get(0));
        taskDropdown.setMaxWidth(Double.MAX_VALUE);
        taskDropdown.setStyle(
                "-fx-background-color: #f8f9fa; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 8; -fx-font-size: 15px;");

        TextField customTaskField = new TextField();
        customTaskField.setPromptText("Or write your task here...");
        customTaskField.setStyle(
                "-fx-background-color: #f8f9fa; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 12; -fx-font-size: 15px;");

        Button addTaskBtn = new Button("+ Add Task");
        addTaskBtn.setMaxWidth(Double.MAX_VALUE);
        addTaskBtn.setStyle(
                "-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px; -fx-padding: 12; -fx-background-radius: 8;");

        limitErrorLabel = new Label();
        limitErrorLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-size: 16px; -fx-font-weight: bold;");
        limitErrorLabel.setMaxWidth(Double.MAX_VALUE);
        limitErrorLabel.setAlignment(Pos.CENTER);

        selectBox.getChildren().addAll(selectLabel, taskDropdown, customTaskField, addTaskBtn, limitErrorLabel);

        taskContainer = new VBox(15);
        taskContainer.setPadding(new Insets(10, 0, 0, 0));

        addTaskBtn.setOnAction(e -> {
            if (taskContainer.getChildren().size() < 5) {
                limitErrorLabel.setText("");

                String finalTask;

                if (!customTaskField.getText().trim().isEmpty()) {
                    finalTask = customTaskField.getText().trim();
                }

                else {
                    finalTask = taskDropdown.getValue();
                }

                addTaskRow(finalTask);
                customTaskField.clear();
            }

            else {
                limitErrorLabel.setText("You can only add 5 tasks !");
            }
        });

        root.getChildren().addAll(headerBox, line, selectBox, taskContainer);
        primaryStage.setScene(new Scene(root, WIN_WIDTH, WIN_HEIGHT));
    }

    private void addTaskRow(String taskName) {
        HBox row = new HBox();
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(15, 20, 15, 20));
        row.setStyle(
                "-fx-background-color: white; -fx-border-color: #e9ecef; -fx-border-radius: 10; -fx-background-radius: 10;");

        Label taskLabel = new Label(taskName);
        taskLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #000000; -fx-font-weight: 500;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button completeBtn = new Button("Complete");
        completeBtn.setStyle(
                "-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 8 18; -fx-background-radius: 8;");

        completeBtn.setOnAction(e -> {
            taskContainer.getChildren().remove(row);
            limitErrorLabel.setText("");
        });

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
