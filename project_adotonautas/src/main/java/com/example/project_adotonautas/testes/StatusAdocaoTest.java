package com.example.project_adotonautas.testes;
import com.example.project_adotonautas.adotonautas_cod.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatusAdocaoTest {
    @Test
    public void testGetValor() {
        StatusAdocao adotado = StatusAdocao.ADOTADO;
        StatusAdocao naoAdotado = StatusAdocao.NAO_ADOTADO;
        assertEquals(true, adotado.getValor());
        assertEquals(false, naoAdotado.getValor());
    }
}
