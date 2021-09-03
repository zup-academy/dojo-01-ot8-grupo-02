package br.com.zup.edu.sitedeviagens.controller;

import br.com.zup.edu.sitedeviagens.controller.form.PaisForm;
import br.com.zup.edu.sitedeviagens.modelo.Pais;
import br.com.zup.edu.sitedeviagens.repository.PaisRepository;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class PaisControllerTest {

    @Autowired
    private PaisRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;


    @Test
    public void deveriaRetornarErroAoNaoEnviarInformacoes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/paises")
                ).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void adicionarComSucesso() throws Exception {
        PaisForm formulario = new PaisForm();
        formulario.setNome("Everton");
        mockMvc.perform(MockMvcRequestBuilders.post("/paises")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(formulario)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}