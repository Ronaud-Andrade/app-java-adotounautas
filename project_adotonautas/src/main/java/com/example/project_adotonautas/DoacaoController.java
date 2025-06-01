package com.example.project_adotonautas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class DoacaoController{

    @FXML
    private RadioButton rb;

    @FXML
    private RadioButton rb2;

    @FXML
    private RadioButton rb3;

    @FXML
    private RadioButton rb4;

    @FXML
    private Button doarbutton;

    private double valortotal = 0;



    public void totalValor(){

        valortotal = 0;

        if (rb.isSelected()) {
            valortotal = 10;
        } else if (rb2.isSelected()) {
            valortotal = 25;
        } else if (rb3.isSelected()) {
            valortotal = 50;
        } else if (rb4.isSelected()) {
            valortotal = 100;
        }

    }

    public void DoarNow(ActionEvent actionEvent) throws IOException {
        totalValor();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Doar");
        alert.setHeaderText("Total que você doou: " + valortotal);
        alert.showAndWait();
    }




}
