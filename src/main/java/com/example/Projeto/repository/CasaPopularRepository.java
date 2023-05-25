package com.example.Projeto.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.Projeto.models.CasaPopular;


public interface CasaPopularRepository extends CrudRepository<CasaPopular, Long> {
    List<CasaPopular> findByNomeContainingIgnoreCase(String nome);

    public List<CasaPopular> findAll();
    
}
