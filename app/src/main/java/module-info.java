module com.application {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.application to javafx.fxml;
    exports com.application;
}
