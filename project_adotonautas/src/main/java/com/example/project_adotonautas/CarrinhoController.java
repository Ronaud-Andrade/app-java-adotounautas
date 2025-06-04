package com.example.project_adotonautas;

import com.example.project_adotonautas.adotonautas_cod.ArmazenaPessoas;
import com.example.project_adotonautas.adotonautas_cod.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLOutput;


public class CarrinhoController {

    @FXML
    private Label lbPrecoResumo;

    @FXML
    private Button aplicarfiltros;

    @FXML
    private VBox vboxProdutos;

    @FXML
    private Button removeButton1;

    @FXML
    private Label lbTotalCompras;

    @FXML
    private Slider sliderpreco;

    @FXML
    private Label lbNomeProduto;

    private double valor = 0;



    public void initialize(){
        //lbPrecoResumo.setText("40.00");

        if(ArmazenaPessoas.getPessoa().isEmpty()){
            adicionarItemNoCarrinho("Kit Banho Pet Clean", 40.0);
            adicionarItemNoCarrinho("Coleira Fashion", 30.0);
            adicionarItemNoCarrinho("Brinquedo Mordedor", 30.0);
        }else{
            for(Produto p : ArmazenaPessoas.getPessoa().get(0).getProdutosComprados()){
                adicionarItemNoCarrinho(p.getNome(), p.getPreco());
            }
        }
    }

    public void adicionarItemNoCarrinho(String nomeProduto, double preco){

        // Cria o SplitPane
        SplitPane splitPane = new SplitPane();
        splitPane.setPrefHeight(120);

        //Cria o AnchorPane (conteúdo do SplitPane)
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(400, 100);

        //Label do nome do produto
        Label labelNome = new Label("Nome do produto: " + nomeProduto);
        labelNome.setLayoutX(10);
        labelNome.setLayoutY(10);

        // Label da quantidade
        Label labelQuantidade = new Label("Quantidade:");
        labelQuantidade.setLayoutX(10);
        labelQuantidade.setLayoutY(40);

        // Spinner da quantidade
        Spinner<Integer> spinner = new Spinner<>(1, 100, 1);
        spinner.setLayoutX(90);
        spinner.setLayoutY(35);
        spinner.setPrefWidth(60);

        // Label do preço unitário
        Label labelPreco = new Label("Preço unitário: R$" + preco);
        labelPreco.setLayoutX(10);
        labelPreco.setLayoutY(70);

        //Botão de selecionar produto
        Button btnVerMais = new Button("Selecionar");
        btnVerMais.setLayoutX(300);
        btnVerMais.setLayoutY(40);

        btnVerMais.setOnAction(
            event -> {
                double total = spinner.getValue() * preco;
                lbNomeProduto.setText("Nome do Produto: " + nomeProduto);
                lbPrecoResumo.setText("Preço: R$ " + total);
                valor = total;
                ArmazenaPessoas.AtibuirValor(valor);
                lbTotalCompras.setText("Total: R$ " + ArmazenaPessoas.getValorTotalCompras());
            });


        // Botão remover
        Button btnRemover = new Button("Remover");
        btnRemover.setLayoutX(300);
        btnRemover.setLayoutY(70);

        // Ação do botão remover
        btnRemover.setOnAction(event -> {
            vboxProdutos.getChildren().remove(splitPane);
            if(ArmazenaPessoas.getPessoa().isEmpty()){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informação");
                alert.setHeaderText("Aviso!");
                alert.setContentText(nomeProduto + " foi removido!");
                alert.showAndWait();

                //System.out.println("Removido com sucesso");
            }else{

                try{
                    for(Produto p : ArmazenaPessoas.getPessoa().get(0).getProdutosComprados()) {
                        if (p.getNome().equals(nomeProduto)) {
                            ArmazenaPessoas.getPessoa().get(0).getProdutosComprados().remove(p);

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Informação");
                            alert.setHeaderText("Aviso!");
                            alert.setContentText(nomeProduto + " foi removido!");
                            alert.showAndWait();
                            //System.out.println("Removido com sucesso!");
                        } else {

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Informação");
                            alert.setHeaderText("Aviso!");
                            alert.setContentText("Não existe produtos!");
                            alert.showAndWait();

                            //System.out.println("Não existe esse produto");
                        }
                    }
                }catch(java.util.ConcurrentModificationException ex){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Informação");
                    alert.setHeaderText("Aviso!");
                    alert.setContentText("Não existe produtos!");
                    alert.showAndWait();
                }

            }

        });

        //Adiciona os elementos dentro do AnchorPane
        anchorPane.getChildren().addAll(labelNome, labelQuantidade, spinner, labelPreco, btnRemover, btnVerMais);

        // Adiciona o AncherPane dentro do SplitPane
        splitPane.getItems().add(anchorPane);

        // Adiciona no VBox principal
        vboxProdutos.getChildren().add(splitPane);

    }

    public void FinalizarCompras(ActionEvent event){

        System.out.println(ArmazenaPessoas.getValorTotalCompras());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText("Valor total a ser pago");
        alert.setContentText("O valor total das compras deram: " + ArmazenaPessoas.getValorTotalCompras());
        alert.showAndWait();

        if(alert.getResult() == ButtonType.OK){
            ArmazenaPessoas.ClearValor();

            lbTotalCompras.setText("Total: R$ XX.XX");

            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Aviso");
            alert1.setHeaderText("Obrigado pela preferência!");
            alert1.showAndWait();
        }


    }

    public void AplicarFiltros(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Carrinho");
        alert.setHeaderText("Filtros aplicados com sucesso");
        alert.setContentText("Preço definido foi de: " + sliderpreco.getValue());
        alert.setGraphic(null);
        alert.show();
        
    }

//    public void removerItem(ActionEvent event){
//        // Descobre qual botão foi clicado
//        Button botaoClicado = (Button) event.getSource();
//
//        // O pai do botão é o AnchorPane da caixinha do produto
//        AnchorPane caixaProduto = (AnchorPane) botaoClicado.getParent();
//
//        // Remove a caixinha do VBox
//        vboxProdutos.getChildren().remove(caixaProduto);
//
//    }

    private void abrirJanela(String janela, String nomeJanela) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(janela));

        Scene scene = new Scene(fxmlLoader.load(), 912.0, 636.0);
        Stage stage = new Stage();
        stage.setTitle(nomeJanela);
        stage.setScene(scene);
        stage.show();
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


}
