package com.example.project_adotonautas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicialApplication extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("pag1.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 730.0, 543.0);
        stage.setScene(scene);
        stage.setTitle("Página Inicial");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }


}
