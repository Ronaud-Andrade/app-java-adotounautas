package com.example.project_adotonautas;


import com.example.project_adotonautas.adotonautas_cod.ArmazenaPessoas;
import com.example.project_adotonautas.adotonautas_cod.Pessoa;
import com.example.project_adotonautas.adotonautas_cod.PetShop;
import com.example.project_adotonautas.adotonautas_cod.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ProdutosController {

    @FXML
    private Button aplicarfiltros;

    @FXML
    private VBox vBoxProduto;

    @FXML
    private MenuItem CarrinhoItem;

    @FXML
    private Slider precoslider;

    private Button addcarrinho;

    PetShop petshop = new PetShop();
    Produto p1 = new Produto("Ração", 20.30);
    Produto p2 = new Produto("Coleira", 40.30);
    Pessoa pe1 = new Pessoa("Iago");


    public void initialize(){
        petshop.adicionarProduto(p1);
        petshop.adicionarProduto(p2);


        //Adicionei a pessoa na classe ArmazanePessoa por meio do mét0do static
        ArmazenaPessoas.setPessoas(pe1);

        if(petshop.getProdutosDisponiveis().isEmpty()){
            addProduto("Kit Banho", 40.3);
        }else{
            for(Produto p : petshop.getProdutosDisponiveis()){
                addProduto(p.getNome(), p.getPreco());
            }
        }


    }

    public void addProduto(String nomeProduto, double preco){
        //Cria o Splitpane
        SplitPane splitPane = new SplitPane();
        splitPane.setPrefHeight(120);

        //Cria o AnchorPane
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(400, 100);

        //Label do nome do produto
        Label labelNome = new Label("Nome do Produto: " + nomeProduto);
        labelNome.setLayoutX(10);
        labelNome.setLayoutY(10);

        //Label do valor
        Label labelPreco = new Label("Preço unitário: R$ " + preco);
        labelPreco.setLayoutX(10);
        labelPreco.setLayoutY(30);

        Button btnComprar = new Button("Comprar");
        btnComprar.setLayoutX(200);
        btnComprar.setLayoutY(30);

        //Função do botão
        btnComprar.setOnAction((e) -> {
            vBoxProduto.getChildren().remove(splitPane);
            for(Produto p : petshop.getProdutosDisponiveis()){
                if(p.getNome().equals(nomeProduto)){
                    pe1.comprarProduto(p);
                    //System.out.println(pe1.getNome() + " comprou o produto " + p.getNome() + " com sucesso e foi adicionado no carrinho de compras.");
                }
            }
        });


        //Adiciona o elementos no AnchorPane
        anchorPane.getChildren().addAll(labelNome, labelPreco, btnComprar);

        //Adiciona o AncherPane dentro do SplitPane
        splitPane.getItems().add(anchorPane);

        //Adiciona no Vbox principal
        vBoxProduto.getChildren().add(splitPane);

    }

    public void AplicarFiltros(ActionEvent actionEvent){

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alerta!");
        alerta.setHeaderText(null);
        alerta.setContentText("Buscando por: " + precoslider.getValue() + "reais.");
        alerta.showAndWait();

    }

    private void abrirJanela(String janela, String nomeJanela) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(janela));

        Scene scene = new Scene(fxmlLoader.load(), 912.0, 636.0);
        Stage stage = new Stage();
        stage.setTitle(nomeJanela);
        stage.setScene(scene);
        stage.show();
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






}
