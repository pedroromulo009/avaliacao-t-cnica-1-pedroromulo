package com.example.Projeto.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.Projeto.models.Familia;


public interface FamiliaRepository extends CrudRepository<Familia, Long> {
    List<Familia> findByNomeContainingIgnoreCase(String nome);

    public List<Familia> findAll();

}

  
