package com.example.project_adotonautas.testes;

import com.example.project_adotonautas.adotonautas_cod.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PetShopTest {

    private PetShop petShop = new PetShop();
    private Produto produto = new Produto("Shampoo Canino", 29.90);

    @Test
    public void testAdicionarProduto() {
        petShop.adicionarProduto(produto);
        assertEquals(1, petShop.getProdutosDisponiveis().size());
        assertEquals("Shampoo Canino", petShop.getProdutosDisponiveis().get(0).getNome());
    }

    @Test
    public void testGetProdutosDisponiveis() {
        petShop.adicionarProduto(produto);
        assertEquals(produto, petShop.getProdutosDisponiveis().get(0));
    }

    @Test
    public void testListarProdutos() {
        petShop.adicionarProduto(produto);
        petShop.listarProdutos();

    }

    @Test
    public void testListarProdutosDoArquivo() {
        petShop.adicionarProduto(produto);
        petShop.listarProdutosDoArquivo("Shampoo Canino, 29.90");

    }

    @Test
    public void testSalvarProdutoNoArquivo() {
        petShop.adicionarProduto(produto);
        petShop.salvarProdutoNoArquivo("Shampoo Canino, 29.90", produto);
    }
}
