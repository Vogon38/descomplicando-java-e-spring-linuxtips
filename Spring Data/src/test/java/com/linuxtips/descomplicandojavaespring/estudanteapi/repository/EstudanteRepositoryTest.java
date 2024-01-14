package com.linuxtips.descomplicandojavaespring.estudanteapi.repository;

import com.linuxtips.descomplicandojavaespring.estudanteapi.model.DadosBancarios;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.Estudante;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.TipoContaBancaria;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EstudanteRepositoryTest {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Test
    @DisplayName("Deve salvar estudante na base com sucesso")
    void deveSalvarEstudanteNaBaseComSucesso(){
        Estudante estudanteSalvo = this.estudanteRepository.save(buildMockEstudante());
        assertNotNull(estudanteSalvo);
        assertEquals("aluno", estudanteSalvo.getNome());
    }

    @Test
    @DisplayName("Deve listar todos os estudantes com sucesso")
    void deveListarTodosOsEstudantesComSucesso() {
        estudanteRepository.save(buildMockEstudante());
        List<Estudante> estudantes = estudanteRepository.findAll();
        assertEquals(1, estudantes.size());
    }

    @Test
    @DisplayName("Deve excluir estudante com sucesso")
    void deveExcluirEstudanteComSucesso() {
        this.estudanteRepository.deleteById(1L);
        Optional<Estudante> estudantes = this.estudanteRepository.findById(1L);
        assertFalse(estudantes.isPresent());
    }

    @Test
    @DisplayName("Deve buscar estudante pelo nome e curso com sucesso")
    void deveBuscarEstudantePeloNomeECursoComSucesso() {
        estudanteRepository.save(buildMockEstudante());
        List<Estudante> estudantes = estudanteRepository.findByNomeStartingWithAndCurso("a", "java");
        assertEquals(1, estudantes.size());
    }

    private Estudante buildMockEstudante(){
        Estudante estudante = new Estudante();
        DadosBancarios dadosBancarios = new DadosBancarios();
        dadosBancarios.setTipoContaBancaria(TipoContaBancaria.valueOf("CORRENTE"));
        dadosBancarios.setDigito(1);
        dadosBancarios.setAgencia(123);
        dadosBancarios.setConta(123456);
        estudante.setNome("aluno");
        estudante.setCurso("java");
        estudante.setEndereco("rua");
        estudante.setDadosBancarios(dadosBancarios);

        return estudante;

    }


}
