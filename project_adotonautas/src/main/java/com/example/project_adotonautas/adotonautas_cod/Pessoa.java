package com.example.project_adotonautas.adotonautas_cod;
import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Pessoa {
    private String nome;
    private ArrayList<Animal> animaisAdotados = new ArrayList<>();
    private ArrayList<Produto> produtosComprados = new ArrayList<>();

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void adotarAnimal(Animal animal) {
        if (animal.isAdotado()) {
            System.out.println("Este animal já foi adotado.");
            return;
        }
        
        animal.setAdotado(true);
        animaisAdotados.add(animal);
        System.out.println(nome + " adotou " + animal);
    }

    public void comprarProduto(Produto produto) {
        produtosComprados.add(produto);
        System.out.println(nome + " comprou " + produto);
    }

    public void salvarAdocoesEmArquivo(String nomeArquivo, Animal animal) {
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(nomeArquivo, true), StandardCharsets.UTF_8)) {
            writer.write(animal.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar adoção: " + e.getMessage());
        }
    }

    public void salvarComprasEmArquivo(String nomeArquivo, Produto produto) {
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(nomeArquivo, true), StandardCharsets.UTF_8)) {
            writer.write(produto.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar compra: " + e.getMessage());
        }
    }

    public void listarAdocoesDoArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            System.out.println("Nenhuma adoção registrada ainda.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(nomeArquivo), StandardCharsets.UTF_8))) {
            System.out.println("Histórico de adoções:");
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler adoções: " + e.getMessage());
        }
    }

    public void listarComprasDoArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            System.out.println("Nenhuma compra registrada ainda.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(nomeArquivo), StandardCharsets.UTF_8))) {
            System.out.println("Histórico de compras:");
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler compras: " + e.getMessage());
        }
    }
}