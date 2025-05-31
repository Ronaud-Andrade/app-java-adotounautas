import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class PetShop {
    private ArrayList<Produto> produtosDisponiveis = new ArrayList<>();

    public ArrayList<Produto> getProdutosDisponiveis() {
        return produtosDisponiveis;
    }

    public void adicionarProduto(Produto produto) {
        produtosDisponiveis.add(produto);
        salvarProdutoNoArquivo("historico-de-produtos.txt", produto);
    }

    public void listarProdutos() {
        System.out.println("Produtos disponíveis:");
        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println((i + 1) + " - " + produtosDisponiveis.get(i));
        }
    }

    public void salvarProdutoNoArquivo(String nomeArquivo, Produto produto) {
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(nomeArquivo, true), StandardCharsets.UTF_8)) {
            writer.write(produto.getNome() + " - R$" + produto.getPreco() + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar produto: " + e.getMessage());
        }
    }

    public void listarProdutosDoArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            System.out.println("Nenhum produto registrado ainda.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(nomeArquivo), StandardCharsets.UTF_8))) {
            System.out.println("Histórico de produtos:");
            String linha;
            int contador = 1;
            while ((linha = reader.readLine()) != null) {
                System.out.println(contador + " - " + linha);
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
}