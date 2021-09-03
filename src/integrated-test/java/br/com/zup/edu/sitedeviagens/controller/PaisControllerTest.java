package br.com.zup.edu.sitedeviagens.controller;

import br.com.zup.edu.sitedeviagens.modelo.Pais;
import br.com.zup.edu.sitedeviagens.repository.PaisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaisControllerTest {

    @Autowired
    private PaisRepository repository;

    private MockMvc mockMvc;

    @Test
    public void adicionarComSucesso() {
        Pais pais = new Pais("Brasil");
        mockMvc.perform(MockMvcRequestBuilders.post("/paises")
                .contentType())

    }




}