package com.example.Projeto.models;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasaPopularTest {

    @Test
    public void test_Lista_Familias_Ordenadas() {
        CasaPopular casaPopular = new CasaPopular();

        //
        casaPopular.adicionarFamilia(new Familia("Familia 1", 800, 2));
        casaPopular.adicionarFamilia(new Familia("Familia 2", 1200, 4));
        casaPopular.adicionarFamilia(new Familia("Familia 3", 1500, 1));

        //
        List<Familia> familiasOrdenadas = casaPopular.getFamiliasOrdenadas();

        //
        Assertions.assertEquals("Familia 1", familiasOrdenadas.get(0).getNome());
        Assertions.assertEquals("Familia 2", familiasOrdenadas.get(1).getNome());
        Assertions.assertEquals("Familia 3", familiasOrdenadas.get(2).getNome());

        


    }

    
}
