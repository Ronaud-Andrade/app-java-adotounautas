package com.example.project_adotonautas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProdutosApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("pag2.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 912.0, 636.0);
        stage.setScene(scene);
        stage.setTitle("Produtos");
        stage.show();
    }
}
