package com.example.project_adotonautas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

    //Mensagem que informa se a pessoa doou
    public void DoarNow(ActionEvent actionEvent) throws IOException {
        totalValor();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Doar");
        alert.setHeaderText("Total que você doou: " + valortotal);
        alert.showAndWait();
    }


    //Mét0do para abrir uma nova janela
    private void abrirJanela(String janela, String nomeJanela) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(janela));

        Scene scene = new Scene(fxmlLoader.load(), 912.0, 636.0);
        Stage stage = new Stage();
        stage.setTitle(nomeJanela);
        stage.setScene(scene);
        stage.show();
    }

    //Muda para Carrinho
    public void changetoCarrinho(ActionEvent actionEvent) throws IOException {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alerta!");
        alerta.setHeaderText(null);
        alerta.setContentText("Você será redirecionado para a pág. de Carrinho!");
        alerta.showAndWait();
        if (alerta.getResult() == ButtonType.OK) {
            abrirJanela("carrinho.fxml", "Página de Carrinho");
            Stage stageAtual = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
            stageAtual.close();
        }
    }

    //Muda para Produtos
    public void changetoProdutos(ActionEvent actionEvent) throws IOException {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alerta!");
        alerta.setHeaderText(null);
        alerta.setContentText("Você será redirecionado para a página de Produtos!");
        alerta.showAndWait();
        if (alerta.getResult() == ButtonType.OK) {
            abrirJanela("pag2.fxml", "Página de Produtos");
            Stage stageAtual = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
            stageAtual.close();
        }
    }




}
