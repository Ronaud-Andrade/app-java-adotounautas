module com.example.project_adotonautas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.project_adotonautas to javafx.fxml;
    exports com.example.project_adotonautas;
}