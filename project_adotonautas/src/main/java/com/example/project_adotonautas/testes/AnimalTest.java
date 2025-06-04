package com.example.project_adotonautas.testes;


import com.example.project_adotonautas.adotonautas_cod.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {


    private Animal gato = new Gato("Mimi", 2, "Siamês");

    @Test
    public void testGetIdade() {
        assertEquals(2, gato.getIdade());
    }

    @Test
    public void testGetNome() {
        assertEquals("Mimi", gato.getNome());
    }

    @Test
    public void testGetRaca() {
        assertEquals("Siamês", gato.getRaca());
    }

    @Test
    public void testIsAdotado() {
        assertEquals(false, gato.isAdotado());
    }

    @Test
    public void testSetAdotado() {
        gato.setAdotado(true);
        assertTrue(gato.isAdotado());
    }

    @Test
    public void testToString() {
        gato.setAdotado(true);
        gato.setAdotado(false);
        assertFalse(gato.isAdotado());
    }
}
