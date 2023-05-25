package com.example.Projeto.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Projeto.builders.FamiliaBuilder;
import com.example.Projeto.models.Familia;
import com.example.Projeto.repository.FamiliaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class FamiliaControllersTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FamiliaRepository familiaRepository;

    private Object mocMvc;

    @BeforeEach
    @AfterEach
    public void deletaDados() {
        familiaRepository.deleteAll();
    }

    @Test
    public void deve_buscar_familia_cadastrada() throws Exception {
        Familia familia1 = new FamiliaBuilder().construir();
        Familia familia2 = new FamiliaBuilder().comNome("familia2").construir();
        familiaRepository.saveAll(Arrays.asList(familia1, familia2));

        ((MockMvc) this.mocMvc)
            .perform(get("/familia"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("familia2")));
    }

    @Test
    public void deve_remover_uma_familia_pelo_id() throws Exception {
        Familia familia1 = new FamiliaBuilder().construir();
        Familia familia2 = new FamiliaBuilder().comNome("familia2").construir();
        familiaRepository.saveAll(Arrays.asList(familia1, familia2));

        this.mockMvc
            .perform(delete("/familia/" + familia1.getId()))
            .andExpect(status().isOk());
        
        List<Familia> familiaRetornados = familiaRepository.findByNomeContainingIgnoreCase(familia1.getNome());
        
        Assertions.assertThat(familiaRetornados).isEmpty();
    }

    @Test
    public void deve_incluir_uma_familia() throws Exception {
        Familia familia = new FamiliaBuilder().construir();
        String json = toJson(familia);
        
        this.mockMvc
            .perform(post("/familia").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isCreated());
            
            List<Familia> familiaRetornados = familiaRepository.findByNomeContainingIgnoreCase(familia.getNome());

            Assertions.assertThat(familiaRetornados.stream().map(Familia::getNome).toList()).contains(familia.getNome());
    }

    private String toJson(Familia familia) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(familia);
        return json;
    }

    @Test
    public void deve_poder_alterar_a_familia() throws Exception {
        Familia familiaAlterado = new FamiliaBuilder().construir();
        familiaRepository.save(familiaAlterado);

        familiaAlterado.setNome("familia3");

        String json = toJson(familiaAlterado);

        this.mockMvc.perform(put("/familia").content(json).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isCreated());
        Familia familiaRetornados = familiaRepository.findById(familiaAlterado.getId()).get();
        Assertions.assertThat(familiaRetornados.getId()).isEqualTo(familiaAlterado.getId());
    }

    
}
