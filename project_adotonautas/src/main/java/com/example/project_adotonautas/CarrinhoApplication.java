package com.example.project_adotonautas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CarrinhoApplication extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("carrinhoteste.fxml"));

        Scene scene = new Scene(loader.load(), 912.0, 543.0);
        stage.setScene(scene);
        stage.setTitle("Carrinho");
        stage.show();
    }
}
