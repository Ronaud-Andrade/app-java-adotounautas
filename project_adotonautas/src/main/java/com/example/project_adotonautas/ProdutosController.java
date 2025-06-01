package com.example.project_adotonautas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

public class ProdutosController {

    @FXML
    private Button aplicarfiltros;

    @FXML
    private Slider precoslider;

    private Button addcarrinho;

    public void AplicarFiltros(ActionEvent actionEvent){

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alerta!");
        alerta.setHeaderText(null);
        alerta.setContentText("Buscando por: " + precoslider.getValue() + "reais.");
        alerta.showAndWait();

    }






}
