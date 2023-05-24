package com.example.Projeto.models;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultadosTest {

    @Test
    public void test_get_familias_aptadas() {
        //
        List<Familia> familias = new ArrayList<>();
        Familia familia1 = new Familia("Familia 1", 800, 2);
        Familia familia2 = new Familia("Familia 2", 1200, 4);
        Familia familia3 = new Familia("Familia 3", 1500, 1);
        familias.add(familia1);
        familias.add(familia2);
        familias.add(familia3);

        //
        Resultados resultados = new Resultados(familias);

        //
        List<Familia> familiasAptadas = resultados.getFamiliasAptadas();

        //
        Assertions.assertEquals(familias, familiasAptadas);


        
    }

    
}
