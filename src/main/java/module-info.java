module com.example.mycalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mycalculator to javafx.fxml;
    exports com.example.mycalculator;
}