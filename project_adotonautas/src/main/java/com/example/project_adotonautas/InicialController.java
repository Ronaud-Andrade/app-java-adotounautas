package com.example.project_adotonautas;

import com.example.project_adotonautas.adotonautas_cod.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLOutput;

public class InicialController {



    @FXML
    private Button aplicarFiltros;

    @FXML
    private ComboBox<String> comboBoxSexo;

    @FXML
    private ComboBox<String> comboEspecie;

    @FXML
    private Label lbNome;

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
    private Label lbRaca;

    @FXML
    private Label lbIdade;

    @FXML
    private TextArea taDescrição;

    @FXML
    private FlowPane flowPaneAnimais;



    private void abrirJanela(String janela, String nomeJanela) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(janela));

        Scene scene = new Scene(fxmlLoader.load(), 912.0, 636.0);
        Stage stage = new Stage();
        stage.setTitle(nomeJanela);
        stage.setScene(scene);
        stage.show();
    }

    ONGs ong = new ONGs();
    Animal gato = new Gato("Gugu", 3, "Siames");
    Animal gato1 = new Gato("Lua", 3, "Siames");
    Pessoa p1 = new Pessoa("Iago");

    @FXML
    private void initialize() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bem-vindo");
        alert.setHeaderText(null);
        alert.setContentText("Bem-vindo ao Adotonautas!");
        alert.showAndWait();

        comboBoxSexo.getItems().addAll("Macho", "Femêa");
        comboEspecie.getItems().addAll("Não definida");

        ong.adicionarAnimal(gato);
        ong.adicionarAnimal(gato1);

        for(Animal a : ong.getAnimaisDisponiveis()){
            System.out.println("Animal: " + a.getNome());
        }

        if(
                ong.getAnimaisDisponiveis().isEmpty()
        ){
            adicionarAnimal("Bella", "Caramelo", 5);
        }else{
            for(Animal animal : ong.getAnimaisDisponiveis()){
                adicionarAnimal(animal.getNome(), animal.getRaca(), animal.getIdade());
            }
        }

//        sliderIdade.getValue();

//        colocar mais especies no comboBox usando as instancias criadas pelas classes


    }

    public void adicionarAnimal(String nome, String raca, int idade){
        // SplitPane
        SplitPane splitPane = new SplitPane();
        splitPane.setPrefHeight(120);
        splitPane.setPrefWidth(400);

        //Anchorpane das infotmações
        AnchorPane anchorPane = new AnchorPane();

        //Label nome
        Label labelNome = new Label("Nome: " + nome);
        labelNome.setLayoutX(10);
        labelNome.setLayoutY(5);
        labelNome.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        //Label raça
        Label labelRaca = new Label("Raça: " + raca);
        labelRaca.setLayoutX(10);
        labelRaca.setLayoutY(30);

        //Label idade
        Label labelIdade = new Label("Idade: " + idade + " anos");
        labelIdade.setLayoutX(10);
        labelIdade.setLayoutY(50);

        //Botão ver mais
        Button btnVerMais = new Button("Ver mais");
        btnVerMais.setLayoutX(200);
        btnVerMais.setLayoutY(5);

        btnVerMais.setOnAction((e) -> {
            //Gera um aviso sobre as informações do animal
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Veja mais do animal");
//            alert.setHeaderText("Animal: " + nome);
//            alert.setContentText("Raca: " + raca + ". Idade: " + idade);
//            alert.showAndWait();

            lbNome.setText("Nome: " + nome);
            lbRaca.setText("Raça: " + raca);
            lbIdade.setText("Idade: " + idade);
            taDescrição.setText(nome + " é um(a) pet muito fofinho e que adora brincar.");


        });

        Button btnAdotar = new Button("Adotar");
        btnAdotar.setLayoutX(200);
        btnAdotar.setLayoutY(40);

        btnAdotar.setOnAction((e) -> {
            flowPaneAnimais.getChildren().remove(splitPane);
             try{

                 for(Animal animal : ong.getAnimaisDisponiveis()){
                     if(animal.getNome().equals(nome)){
                         p1.adotarAnimal(animal);
                         ong.getAnimaisDisponiveis().remove(animal);
                     }
                 }


             } catch (Exception ex) {
                 System.out.println("Não existem mais animais");
             }
        });

        //Botão de Remover Animal
        Button btnRemover = new Button("Remover");
        btnRemover.setLayoutX(200);
        btnRemover.setLayoutY(90);

        btnRemover.setOnAction((e) -> {
            //Remover elementos
            flowPaneAnimais.getChildren().remove(splitPane);
            try{

                for(Animal a : ong.getAnimaisDisponiveis()){
                    System.out.println("Animal: " + a.getNome());
                }

                for(Animal a : ong.getAnimaisDisponiveis()){
                    if(a.getNome().equals(nome)){
                        ong.getAnimaisDisponiveis().remove(a);
                    }
                }


            } catch (java.util.ConcurrentModificationException ex) {
                System.out.println("Não existem animais.");
            }


        });

        //Adiciona os elementos dentro do anchorPane
        anchorPane.getChildren().addAll(labelNome, labelRaca, labelIdade, btnVerMais, btnRemover, btnAdotar);


        // Adiciona o pane no SplitPane
        splitPane.getItems().addAll(anchorPane);

        // Adiciona no FlowPane principal
        flowPaneAnimais.getChildren().add(splitPane);


    }

    //Muda para Carrinho
    public void changetoCarrinho(ActionEvent actionEvent) throws IOException {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alerta!");
        alerta.setHeaderText(null);
        alerta.setContentText("Você será redirecionado para a pág. de Carrinho!");
        alerta.showAndWait();
        if (alerta.getResult() == ButtonType.OK) {
            abrirJanela("carrinhoteste.fxml", "Página de Carrinho");
            //Página atual
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

    //Muda para Doação
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
