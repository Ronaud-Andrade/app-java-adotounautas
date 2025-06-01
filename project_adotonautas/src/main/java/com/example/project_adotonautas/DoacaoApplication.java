package com.example.project_adotonautas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DoacaoApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Doacao2.fxml"));
        fxmlLoader.setController(new DoacaoController());

        Scene scene = new Scene(fxmlLoader.load(), 912.0, 543.0);
        stage.setScene(scene);
        stage.setTitle("Doe-nós");
        stage.show();
    }
}
