package com.example.project_adotonautas.testes;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;

import com.example.project_adotonautas.adotonautas_cod.*;
import org.junit.Test;


import static org.junit.Assert.*;

public class ArmazenaPessoasTest {

    @Before
    public void setUp() {
        ArmazenaPessoas.ClearValor();
        ArmazenaPessoas.getPessoa().clear();
    }

    @Test
    public void testAtibuirValor() {
        ArmazenaPessoas.AtibuirValor(100.00);
        ArmazenaPessoas.AtibuirValor(50.00);
        assertEquals(150.00, ArmazenaPessoas.getValorTotalCompras(), 0.001);
    }

    @Test
    public void testClearValor() {
        ArmazenaPessoas.AtibuirValor(200.00);
        ArmazenaPessoas.ClearValor();
        assertEquals(0.00, ArmazenaPessoas.getValorTotalCompras(), 0.001);
    }

    @Test
    public void testGetPessoa() {
        Pessoa pessoaUm = new Pessoa("Iago");
        Pessoa pessoaDois = new Pessoa("Ronaud");
        Pessoa pessoaTres = new Pessoa("João");
        ArmazenaPessoas.setPessoas(pessoaUm);
        ArmazenaPessoas.setPessoas(pessoaDois);
        ArmazenaPessoas.setPessoas(pessoaTres);
        assertEquals(pessoaUm, ArmazenaPessoas.getPessoa().get(0));
        assertEquals(pessoaDois, ArmazenaPessoas.getPessoa().get(1));
        assertEquals(pessoaTres, ArmazenaPessoas.getPessoa().get(2));
    }

    @Test
    public void testGetValorTotalCompras() {
        ArmazenaPessoas.AtibuirValor(100.00);
        ArmazenaPessoas.AtibuirValor(50.00);
        assertEquals(150.00, ArmazenaPessoas.getValorTotalCompras(), 0.001);
    }

    @Test
    public void testSetPessoas() {
        Pessoa pessoaUm = new Pessoa("Iago");
        Pessoa pessoaDois = new Pessoa("Ronaud");
        Pessoa pessoaTres = new Pessoa("João");
        ArmazenaPessoas.setPessoas(pessoaUm);
        ArmazenaPessoas.setPessoas(pessoaDois);
        ArmazenaPessoas.setPessoas(pessoaTres);
        assertEquals(3, ArmazenaPessoas.getPessoa().size());
    }
}
