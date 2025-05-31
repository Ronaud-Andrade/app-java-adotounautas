package com.example.project_adotonautas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class InicialController {



    @FXML
    private Button aplicarFiltros;

    @FXML
    private ComboBox<String> comboBoxSexo;

    @FXML
    private ComboBox<String> comboEspecie;

    @FXML
    private Label seuLabel;

    @FXML
    private MenuItem CarrinhoItem;

    @FXML
    private MenuItem menuItemDoacao;

    @FXML
    private MenuItem ProdutosItem;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Slider sliderIdade;

    @FXML
    private TextArea seuTextArea;

    @FXML
    private ImageView suaImagem;

    private void abrirJanela(String janela, String nomeJanela) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(janela));

        Scene scene = new Scene(fxmlLoader.load(), 912.0, 636.0);
        Stage stage = new Stage();
        stage.setTitle(nomeJanela);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void initialize() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bem-vindo");
        alert.setHeaderText(null);
        alert.setContentText("Bem-vindo ao Adotonautas!");
        alert.showAndWait();

        comboBoxSexo.getItems().addAll("Macho", "Femêa");
        comboEspecie.getItems().addAll("Não definida");

//        sliderIdade.getValue();

//        colocar mais especies no comboBox usando as instancias criadas pelas classes


    }


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

    public void changeDoacao(ActionEvent actionEvent) throws IOException {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alerta!");
        alerta.setHeaderText(null);
        alerta.setContentText("Você será redirecionado para a pág. de Doe-nós!");
        alerta.showAndWait();
        if (alerta.getResult() == ButtonType.OK) {
            abrirJanela("doacao2.fxml", "Página de Doação");
            Stage stageAtual = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
            stageAtual.close();
        }
    }

    public void filtros(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Filtros Aplicados");
        alert.setHeaderText(null);
        int valor = (int) sliderIdade.getValue();
        alert.setContentText("Os filtros são:" + comboBoxSexo.getValue() + ", " + comboEspecie.getValue() + ", " + valor);
        alert.showAndWait();
    }
}
