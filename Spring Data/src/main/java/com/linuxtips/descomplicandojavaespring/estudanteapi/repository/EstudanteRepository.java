package com.linuxtips.descomplicandojavaespring.estudanteapi.repository;

import com.linuxtips.descomplicandojavaespring.estudanteapi.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

    @Query("SELECT c FROM Estudante c WHERE c.nome = ?1")
    Optional<Estudante> findByName(String nome);

    @Query("SELECT c FROM Estudante c WHERE c.curso = ?1")
    List<Estudante> findByCurso(String curso);

    @Query("SELECT c FROM Estudante c WHERE c.dadosBancarios = ?1")
    List<Estudante> findByMeioDePagamento(Long meioDePagamento);

    @Query("SELECT c FROM Estudante c WHERE c.endereco = ?1")
    List<Estudante> findByEndereco(String endereco);

    List<Estudante> findByNomeStartingWith(String nome);

    List<Estudante> findByNomeStartingWithAndCurso(String nome, String curso);

    List<Estudante> findByEnderecoStartingWithOrderByEnderecoDesc(String endereco);

    List<Estudante> findByIdLessThanEqual(Long id);

}
