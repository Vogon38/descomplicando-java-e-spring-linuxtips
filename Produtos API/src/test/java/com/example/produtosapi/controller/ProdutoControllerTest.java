package com.example.produtosapi.controller;

import com.example.produtosapi.model.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTest {

    // Necessário executar a aplicação antes de executar os testes

    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Sucesso - Deve retornar um produto buscando pelo id com sucesso")
    public void deveRetornarUmProdutoBuscandoPeloId() throws Exception{
        this.mockMvc.perform(get("/produtos/{id}", 123)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Sucesso - Deve excluir um produto buscando pelo id com sucesso")
    public void deveCriarUmProduto() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/produtos")
                        .content(asJsonString(new Produto(UUID.randomUUID().toString(), "Produto 123", "10")))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
