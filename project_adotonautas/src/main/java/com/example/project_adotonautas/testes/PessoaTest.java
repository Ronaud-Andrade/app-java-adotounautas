package com.example.project_adotonautas.testes;

import com.example.project_adotonautas.adotonautas_cod.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PessoaTest {

    private Pessoa pessoa = new Pessoa("João");
    private Animal cachorro = new Cachorro("Morganinho", 5, "Pastor Alemão");
    private Produto produto = new Produto("Ração", 25.00);

    @Test
    public void testAdotarAnimal() {
        pessoa.adotarAnimal(cachorro);
        assertEquals(true, cachorro.isAdotado());
    }

    @Test
    public void testComprarProduto() {
        pessoa.comprarProduto(produto);
    }

    @Test
    public void testListarAdocoesDoArquivo() {
        pessoa.adotarAnimal(cachorro);
        pessoa.listarAdocoesDoArquivo("Morganinho,5, Pastor Alemão");
    }

    @Test
    public void testListarComprasDoArquivo() {
        pessoa.comprarProduto(produto);
        pessoa.listarComprasDoArquivo("Ração, 25.00");
    }

    @Test
    public void testSalvarAdocoesEmArquivo() {
        pessoa.adotarAnimal(cachorro);
        pessoa.salvarAdocoesEmArquivo("Morganinho,5, Pastor Alemão", cachorro);
    }

    @Test
    public void testSalvarComprasEmArquivo() {
        pessoa.comprarProduto(produto);
        pessoa.salvarComprasEmArquivo("Ração, 25.00", produto);
    }
}
