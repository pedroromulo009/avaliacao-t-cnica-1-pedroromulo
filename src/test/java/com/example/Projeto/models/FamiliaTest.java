package com.example.Projeto.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FamiliaTest {

    @Test
    public void testCalcularPontuacao() {
        //
        Familia familia1 = new Familia("Familia 1", 800, 2);
        Familia familia2 = new Familia("Familia 2", 1200, 4);
        Familia familia3 = new Familia("Familia 3", 1500, 1);

        //Calculo
        int pontuacaoFamilia1 = familia1.calcularPontuacao();
        int pontuacaoFamilia2 = familia2.calcularPontuacao();
        int pontuacaoFamilia3 = familia3.calcularPontuacao();

        //
        Assertions.assertEquals(7, pontuacaoFamilia1);
        Assertions.assertEquals(6, pontuacaoFamilia2);
        Assertions.assertEquals(5, pontuacaoFamilia3);


    }
    
    
}
