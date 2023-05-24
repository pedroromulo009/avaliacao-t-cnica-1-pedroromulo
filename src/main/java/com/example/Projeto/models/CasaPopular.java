package com.example.Projeto.models;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CasaPopular {

    public static void main(String[] args) {
    }
    
    public void adicionarFamilia(Familia familia) {
    }
    
    public List<Familia> getFamiliasOrdenadas() {
        List<Familia> listaFamilias = new ArrayList<>();
        
        // Adicione as famílias na lista com seus respectivos dados (nome, renda total, número de dependentes)
        listaFamilias.add(new Familia("Familia 1", 800, 2));
        listaFamilias.add(new Familia("Familia 2", 1200, 4));
        listaFamilias.add(new Familia("Familia 3", 1500, 1));
        
        // Ordenar a lista de famílias com base na pontuação
        Collections.sort(listaFamilias, Comparator.comparingInt(Familia::calcularPontuacao).reversed());
        
        // Exibir a lista ordenada
        System.out.println("Lista de Famílias Aptas à Casa Popular:");
        System.out.println("--------------------------------------");
        for (Familia familia : listaFamilias) {
            System.out.println("Família: " + familia.getNome());
            System.out.println("Pontuação: " + familia.calcularPontuacao());
            System.out.println("--------------------------------------");
        }
        return listaFamilias;
    }
}