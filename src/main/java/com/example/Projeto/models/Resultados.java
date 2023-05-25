package com.example.Projeto.models;

import java.util.List;
import javax.persistence.ManyToMany;


public class Resultados {
    
    @ManyToMany
    private List<Familia> familiasAptadas;

    public Resultados(List<Familia> familiasAptadas) {
        this.familiasAptadas = familiasAptadas;
    }

    public List<Familia> getFamiliasAptadas() {
        return familiasAptadas;
    }
    
}
