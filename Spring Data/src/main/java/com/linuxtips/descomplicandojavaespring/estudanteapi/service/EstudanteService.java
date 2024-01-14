package com.linuxtips.descomplicandojavaespring.estudanteapi.service;

import com.linuxtips.descomplicandojavaespring.estudanteapi.exception.EstudanteDuplicadoException;
import com.linuxtips.descomplicandojavaespring.estudanteapi.exception.EstudanteNaoEncontradoException;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.Estudante;
import com.linuxtips.descomplicandojavaespring.estudanteapi.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public Estudante criarEstudante(Estudante estudante) throws EstudanteDuplicadoException {
        try {
            return estudanteRepository.save(estudante);
        } catch (Exception e) {
            throw new EstudanteDuplicadoException("Estudante com o mesmo nome já cadastrado");
        }

    }

    public List<Estudante> listarEstudantes(){
        return estudanteRepository.findAll();
    }

    public Optional<Estudante> buscarEstudantePeloId(Long id) throws Exception{
        if (estudanteRepository.findById(id).isEmpty()) {
            throw new EstudanteNaoEncontradoException(id);
        }

        return estudanteRepository.findById(id);
    }

    public ResponseEntity<Estudante> atualizarEstudantePeloId(Long id, Estudante estudante){
        return estudanteRepository.findById(id)
                .map(estudanteToUpdate -> {
                    estudanteToUpdate.setNome(estudante.getNome());
                    estudanteToUpdate.setEndereco(estudante.getEndereco());
                    estudanteToUpdate.setDadosBancarios(estudante.getDadosBancarios());
                    estudanteToUpdate.setCurso(estudante.getCurso());
                    Estudante updated = estudanteRepository.save(estudanteToUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> excluirEstudantePeloId(Long id){
        return estudanteRepository.findById(id)
                .map(estudanteToDelete -> {
                    estudanteRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Estudante> buscarEstudantePeloNome(String nome){
        return estudanteRepository.findByName(nome)
                .map(estudante -> ResponseEntity.ok().body(estudante))
                .orElse(ResponseEntity.notFound().build());
    }

    public List<Estudante> buscarEstudantePeloCurso(String curso){
        return estudanteRepository.findByCurso(curso);
    }

    public List<Estudante> buscarEstudantePeloMeioDePagamento(Long meioDePagamento){
        return estudanteRepository.findByMeioDePagamento(meioDePagamento);
    }

    public List<Estudante> buscarEstudantePeloEndereco(String endereco){
        return estudanteRepository.findByEndereco(endereco);
    }

    public List<Estudante> buscarEstudantePeloNomeComecandoCom(String nome){
        return estudanteRepository.findByNomeStartingWith(nome);
    }

    public List<Estudante> buscarEstudantePeloNomeComecandoComEComCurso(String nome, String curso){
        return estudanteRepository.findByNomeStartingWithAndCurso(nome, curso);
    }

    public List<Estudante> buscarEstudantePeloEnderecoComecandoComEOrdenadoDesc(String endereco){
        return estudanteRepository.findByEnderecoStartingWithOrderByEnderecoDesc(endereco);
    }

    public List<Estudante> buscarPrimeirosEstudantes(Long id){
        return estudanteRepository.findByIdLessThanEqual(id);
    }

}
