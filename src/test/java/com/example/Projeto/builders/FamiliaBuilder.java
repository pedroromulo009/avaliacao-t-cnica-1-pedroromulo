package com.example.Projeto.builders;

import com.example.Projeto.models.Familia;

public class FamiliaBuilder {
    private String nome = "Familia1";
    private double rendaTotal = 1200;
    private int numeroDependentes = 3;

    public FamiliaBuilder() throws Exception {
        
    }

    public Familia construir() throws Exception {
        return new Familia(nome, rendaTotal, numeroDependentes);
    }

    public FamiliaBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public FamiliaBuilder comRendaTotal(double rendaTotal) {
        this.rendaTotal = rendaTotal;
        return this;
    }

    public FamiliaBuilder comNumeroDeDependentes(int numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
        return this;
    }

}

