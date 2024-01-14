package com.linuxtips.descomplicandojavaespring.estudanteapi.service;

import com.linuxtips.descomplicandojavaespring.estudanteapi.exception.EstudanteDuplicadoException;
import com.linuxtips.descomplicandojavaespring.estudanteapi.exception.EstudanteNaoEncontradoException;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.DadosBancarios;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.Estudante;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.TipoContaBancaria;
import com.linuxtips.descomplicandojavaespring.estudanteapi.repository.EstudanteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EstudanteServiceTest {

    @Mock // classe auxiliar de teste
    private EstudanteRepository estudanteRepository;

    @InjectMocks // classe que será testada
    private EstudanteService estudanteService;

    @Test
    @DisplayName("Sucesso - Deve salvar estudante na base com sucesso")
    void deveSalvarEstudanteNaBaseComSucesso() throws EstudanteDuplicadoException {
        Estudante estudante = this.buildMockEstudante();
        this.estudanteService.criarEstudante(estudante);
        verify(this.estudanteRepository).save(estudante);
    }

    @Test
    @DisplayName("Sucesso - Deve lançar exceção ao tentar salvar estudante duplicado")
    void deveLancarExcecaoAoTentarSalvarEstudanteDuplicado() throws EstudanteDuplicadoException {
        Estudante estudante = this.buildMockEstudante();
        this.estudanteService.criarEstudante(estudante);
        assertThrows(EstudanteDuplicadoException.class, () -> this.estudanteService.criarEstudante(estudante));
    }

    @Test
    @DisplayName("Sucesso - Deve salvar estudante na base com sucesso e sem lançar exceção")
    void deveSalvarEstudanteNaBaseComSucessoESemLancarExcecao() throws EstudanteDuplicadoException {
        Estudante estudante = this.buildMockEstudante();
        this.estudanteService.criarEstudante(estudante);
        assertDoesNotThrow(() -> this.estudanteService.criarEstudante(estudante));
    }

    @Test
    @DisplayName("Sucesso - Deve listar os estudantes com sucesso")
    void deveListarEstudantesComSucesso() {
        Estudante estudante = this.buildMockEstudante();
        when(estudanteRepository.findAll()).thenReturn(List.of(estudante));
        List<Estudante> estudantes = this.estudanteService.listarEstudantes();
        assertEquals(1, estudantes.size());
        verify(this.estudanteRepository).findAll();
    }

    @Test
    @DisplayName("Sucesso - Deve listar estudante pelo nome com sucesso")
    void deveListarEstudantePeloNomeComSucesso() {
        Estudante estudante = this.buildMockEstudante();
        when(estudanteRepository.findByName("al"))
                .thenReturn(Optional.of(estudante));
        var estudanteBase = this.estudanteService.buscarEstudantePeloNome("al");

        assertEquals(estudante.getNome(), estudanteBase.getBody().getNome());
    }

    @Test
    @DisplayName("Erro - Deve lançar exceção ao tentar listar estudante pelo id e não encontrar")
    void deveLancarExcecaoAoTentarListarEstudantePeloIdENaoEncontrar() throws EstudanteNaoEncontradoException {
        Estudante estudante = this.buildMockEstudante();
        when(estudanteRepository.findById(1L))
                .thenReturn(Optional.empty());

        Exception exception = assertThrows(EstudanteNaoEncontradoException.class,
                () -> estudanteService.buscarEstudantePeloId(1L));

        assertEquals("Estudante com o id 1 não encontrado", exception.getMessage());
        verify(this.estudanteRepository).findById(1L);
    }

    @Test
    @DisplayName("Sucesso - Deve atualizar estudante pelo id com sucesso")
    void deveAtualizarEstudantePeloIdComSucesso() {
        Estudante estudante = this.buildMockEstudante();
        Estudante estudanteAtualizado = this.buildMockEstudante();
        estudanteAtualizado.setNome("Novo Nome");

        when(estudanteRepository.findById(1L)).thenReturn(Optional.of(estudante));
        when(estudanteRepository.save(any())).thenReturn(estudanteAtualizado);
        Estudante estudanteAtualizadoResponse = estudanteService.atualizarEstudantePeloId(1L, estudanteAtualizado).getBody();

        verify(estudanteRepository, times(1)).save(argThat(savedEstudante ->
                        savedEstudante.getId().equals(1L) &&
                                savedEstudante.getNome().equals("Novo Nome")));
        assertEquals("Novo Nome", estudanteAtualizadoResponse.getNome());
    }

    private Estudante buildMockEstudante(){
        Estudante estudante = new Estudante();
        DadosBancarios dadosBancarios = new DadosBancarios();
        dadosBancarios.setTipoContaBancaria(TipoContaBancaria.valueOf("CORRENTE"));
        dadosBancarios.setDigito(1);
        dadosBancarios.setAgencia(123);
        dadosBancarios.setConta(123456);
        estudante.setId(1L);
        estudante.setNome("aluno");
        estudante.setCurso("java");
        estudante.setEndereco("rua");
        estudante.setDadosBancarios(dadosBancarios);

        return estudante;

    }

}
