package com.example.Projeto.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.Projeto.models.Resultados;


public interface ResultadosRepository extends CrudRepository<Resultados, Long> {
    List<Resultados> findByNomeContainingIgnoreCase(String nome);

    public List<Resultados> findAll();
    
}
