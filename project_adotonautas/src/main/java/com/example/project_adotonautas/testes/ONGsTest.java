package com.example.project_adotonautas.testes;

import com.example.project_adotonautas.adotonautas_cod.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class ONGsTest {

    private ONGs ongs = new ONGs();
    private Animal cachorro = new Cachorro("Thor", 4, "Labrador");
    private Animal gato = new Gato("Luna", 2, "Siamês");

    @Test
    public void testAdicionarAnimal() {
        ongs.adicionarAnimal(cachorro);
        ongs.adicionarAnimal(gato);
        assertEquals(2, ongs.getAnimaisDisponiveis().size());

    }

    @Test
    public void testGetAnimaisDisponiveis() {
        ongs.adicionarAnimal(cachorro);
        ongs.adicionarAnimal(gato);
        assertEquals(cachorro, ongs.getAnimaisDisponiveis().get(0));
        assertEquals(gato, ongs.getAnimaisDisponiveis().get(1));
    }

    @Test
    public void testGetIdadeAnimal() {
        ongs.adicionarAnimal(cachorro);
        ongs.adicionarAnimal(gato);
        assertEquals(4, ongs.getIdadeAnimal(0));
        assertEquals(2, ongs.getIdadeAnimal(1));

    }

    @Test
    public void testGetNomeAnimal() {
        ongs.adicionarAnimal(cachorro);
        ongs.adicionarAnimal(gato);
        assertEquals("Thor", ongs.getNomeAnimal(0));
        assertEquals("Luna", ongs.getNomeAnimal(1));
    }

    @Test
    public void testGetRacaAnimal() {
        ongs.adicionarAnimal(cachorro);
        ongs.adicionarAnimal(gato);
        assertEquals("Labrador", ongs.getRacaAnimal(0));
        assertEquals("Siamês", ongs.getRacaAnimal(1));
    }

    @Test
    public void testListarAnimaisDisponiveis() {
        ongs.adicionarAnimal(cachorro);
        ongs.adicionarAnimal(gato);
        ongs.listarAnimaisDisponiveis();
    }
}
