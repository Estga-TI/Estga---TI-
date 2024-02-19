package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PimPamPumTest {



@Test
    void testeNumeroDivisivelPor357() {
        assertEquals("Pim", PimPamPum.Divisibilidade(6));
        assertEquals("Pam", PimPamPum.Divisibilidade(10));
        assertEquals("Pum", PimPamPum.Divisibilidade(14));

        assertEquals("PimPam", PimPamPum.Divisibilidade(60));
        assertEquals("PamPum", PimPamPum.Divisibilidade(140));
        assertEquals("PimPum", PimPamPum.Divisibilidade(21));
        assertEquals("PimPamPum", PimPamPum.Divisibilidade(210));
    }

    @Test
    void testeNumeroPresenca357() {
        assertEquals("Pim", PimPamPum.Presenca(13));
        assertEquals("Pam", PimPamPum.Presenca(52));
        assertEquals("Pum", PimPamPum.Presenca(47));
        assertEquals("PimPamPum", PimPamPum.Presenca(3571));
    }

    @Test
    void testeNumeroDivisivelComPresenca() {
        assertEquals("PimPam", PimPamPum.Verificacoes(54));
        assertEquals("PamPum", PimPamPum.Verificacoes(170));
        assertEquals("PumPim", PimPamPum.Verificacoes(238));
        assertEquals("PimPamPum", PimPamPum.Verificacoes(720));
    }

    @Test
    void testeNumeroDecimais() {
        assertEquals("PimPamPum", PimPamPum.Verificacoes(2.357));
        assertEquals("PimPim", PimPamPum.Verificacoes(3.3));
        assertEquals("PamPamPumPum", PimPamPum.Verificacoes(55.77));
    }

    @Test
    void testeNumeroNaoDivisivelSemNumero() {
        assertEquals("2", PimPamPum.Verificacoes(2));
        assertEquals("4.4", PimPamPum.Verificacoes(4.4));
    }

    @Test
    void testeNumeroNegativo() {
        assertEquals("-2", PimPamPum.Verificacoes(-2));
        assertEquals("-4.4", PimPamPum.Verificacoes(-4.4));
        assertEquals("Pum", PimPamPum.Verificacoes(-4.47));
        assertEquals("PamPam", PimPamPum.Verificacoes(-5));
        assertEquals("PimPamPum", PimPamPum.Divisibilidade(-210));
    }


}