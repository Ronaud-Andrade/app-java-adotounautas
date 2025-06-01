package com.example.project_adotonautas.adotonautas_cod;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ONGs ong = new ONGs();
        PetShop petShop = new PetShop();
        Pessoa pessoa = new Pessoa("Iago");

        // Adiciona animais iniciais
        ong.adicionarAnimal(new Cachorro("Rex", 3, "Labrador"));
        ong.adicionarAnimal(new Gato("Mimi", 2, "Siames"));

        // Adiciona produtos iniciais
        petShop.adicionarProduto(new Produto("Ração", 25.0));
        petShop.adicionarProduto(new Produto("Coleira", 15.0));

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Ver animais disponíveis");
            System.out.println("2 - Adotar animal");
            System.out.println("3 - Ver produtos disponíveis");
            System.out.println("4 - Comprar produto");
            System.out.println("5 - Ver adoções");
            System.out.println("6 - Ver compras");
            System.out.println("7 - Ver histórico de produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        ong.listarAnimaisDisponiveis();
                        break;
                    case 2:
                        ong.listarAnimaisDisponiveis();
                        System.out.print("Digite o número do animal para adotar: ");
                        int escolhaAnimal = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (escolhaAnimal > 0 && escolhaAnimal <= ong.getAnimaisDisponiveis().size()) {
                            Animal animal = ong.getAnimaisDisponiveis().get(escolhaAnimal - 1);
                            pessoa.adotarAnimal(animal);
                            pessoa.salvarAdocoesEmArquivo("historico-de-adocoes.txt", animal);
                        } else {
                            System.out.println("Número inválido!");
                        }
                        break;
                    case 3:
                        petShop.listarProdutos();
                        break;
                    case 4:
                        petShop.listarProdutos();
                        System.out.print("Digite o número do produto para comprar: ");
                        int escolhaProduto = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (escolhaProduto > 0 && escolhaProduto <= petShop.getProdutosDisponiveis().size()) {
                            Produto produto = petShop.getProdutosDisponiveis().get(escolhaProduto - 1);
                            pessoa.comprarProduto(produto);
                            pessoa.salvarComprasEmArquivo("historico-de-compras.txt", produto);
                        } else {
                            System.out.println("Número inválido!");
                        }
                        break;
                    case 5:
                        pessoa.listarAdocoesDoArquivo("historico-de-adocoes.txt");
                        break;
                    case 6:
                        pessoa.listarComprasDoArquivo("historico-de-compras.txt");
                        break;
                    case 7:
                        petShop.listarProdutosDoArquivo("historico-de-produtos.txt");
                        break;
                    case 0:
                        System.out.println("Encerrando...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: Digite um número válido.");
                scanner.nextLine();
            }
        }
    }
}