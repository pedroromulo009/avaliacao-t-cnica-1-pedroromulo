package com.example.Projeto.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Familia")
@Data


public class Familia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id 
    private Long id;
    private String nome;
    private double rendaTotal;
    private int numeroDependentes;

    public Familia(String nome, double rendaTotal, int numeroDependentes) {
        this.nome = nome;
        this.rendaTotal = rendaTotal;
        this.numeroDependentes = numeroDependentes;
    }

    public String getNome() {
        return nome;
    }

    public double getRendaTotal() {
        return rendaTotal;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public int calcularPontuacao() {
        int pontos = 0;

        if (rendaTotal <= 900) {
            pontos += 5;
        } else if (rendaTotal <= 1500) {
            pontos += 3;
        }

        if (numeroDependentes >= 3) {
            pontos += 3;
        } else if (numeroDependentes >= 1) {
            pontos += 2;
        }

        return pontos;
    }

    
}