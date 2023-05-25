package com.example.Projeto.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.Projeto.models.Familia;
import com.example.Projeto.repository.FamiliaRepository;

@RestController
@RequestMapping(path = "/familia" , produces = MediaType.APPLICATION_JSON_VALUE)
public class FamiliaControllers {
    
    @Autowired
    private FamiliaRepository familiaRepository;
    
    @GetMapping
    public ResponseEntity<List<Familia>> buscarTodos() {
        Iterable<Familia> iterable = familiaRepository.findAll();
        List<Familia> familia = new ArrayList<>();
        iterable.forEach(familia::add);
        return ResponseEntity.ok().body(familia);
    }

    @DeleteMapping(path= "/{id}")
    public void remover(@PathVariable Long id) {
        familiaRepository.deleteById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Familia> cadastrar(@RequestBody Familia familia){
        Familia familiaCadastrado = familiaRepository.save(familia);
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaCadastrado);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Familia> alterar(@RequestBody Familia familia){
        Familia familiaCadastrado = familiaRepository.save(familia);
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaCadastrado);
    }

}

