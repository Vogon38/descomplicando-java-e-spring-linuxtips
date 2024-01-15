package com.linuxtips.descomplicandojavaespring.estudanteapi.controller;

import com.linuxtips.descomplicandojavaespring.estudanteapi.exception.EstudanteDuplicadoException;
import com.linuxtips.descomplicandojavaespring.estudanteapi.model.Estudante;
import com.linuxtips.descomplicandojavaespring.estudanteapi.service.EstudanteService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class EstudanteController {

    Counter novosEstudantes;
    Counter estudanteDesmatriculados;

    @Autowired
    private EstudanteService estudanteService;

    public EstudanteController(MeterRegistry registry) {
        novosEstudantes = Counter.builder("estudantes.novos"). description("Novos estudantes").register(registry);
        estudanteDesmatriculados = Counter.builder("estudantes.desmatriculados"). description("Estudantes desmatriculados").register(registry);
    }

    @PostMapping("/estudantes")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudante criarEstudante(@RequestBody Estudante estudante) throws EstudanteDuplicadoException {
        novosEstudantes.increment();
        return estudanteService.criarEstudante(estudante);
    }

    @GetMapping("/estudantes")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarEstudantes(){
        return estudanteService.listarEstudantes();
    }

    @GetMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Estudante> buscarEstudantePeloId(@PathVariable(value = "id") Long id) throws Exception{
            return estudanteService.buscarEstudantePeloId(id);
    }

    @PutMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> atualizarEstudantePeloId(@PathVariable(value = "id") Long id, @RequestBody Estudante estudante){
        return estudanteService.atualizarEstudantePeloId(id, estudante);
    }

    @DeleteMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> excluirEstudantePeloId(@PathVariable(value = "id") Long id){
        estudanteDesmatriculados.increment();
        return estudanteService.excluirEstudantePeloId(id);
    }

    @GetMapping("/estudantes/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> buscarEstudantePeloNome(@PathVariable(value = "nome") String nome){
        return estudanteService.buscarEstudantePeloNome(nome);
    }

    @GetMapping("/estudantes/curso")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> buscarEstudantePeloCurso(@RequestParam String nome_curso){
        return estudanteService.buscarEstudantePeloCurso(nome_curso);
    }

    @GetMapping("/estudantes/meioDePagamento/{meio_de_pagamento}")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> buscarEstudantePeloMeioDePagamento(@PathVariable(value = "meio_de_pagamento") Long meio_de_pagamento){
        return estudanteService.buscarEstudantePeloMeioDePagamento(meio_de_pagamento);
    }

    @GetMapping("/estudantes/endereco/{endereco}")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> buscarEstudantePeloEndereco(@PathVariable(value = "endereco") String endereco){
        return estudanteService.buscarEstudantePeloEndereco(endereco);
    }

    @GetMapping("/estudantes/nome")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> buscarEstudantePeloNomeComecandoCom(@RequestParam String nome){
        return estudanteService.buscarEstudantePeloNomeComecandoCom(nome);
    }

    @GetMapping("/estudantes/nome-curso")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> buscarEstudantePeloNomeComecandoComEComCurso(@RequestParam String nome, @RequestParam String curso){
        return estudanteService.buscarEstudantePeloNomeComecandoComEComCurso(nome, curso);
    }

    @GetMapping("/estudantes/endereco")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> buscarEstudantePeloEnderecoComecandoComEOrdenado(@RequestParam String endereco){
        return estudanteService.buscarEstudantePeloEnderecoComecandoComEOrdenadoDesc(endereco);
    }

    @GetMapping("/estudantes/promo")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> buscarPrimeirosEstudantes(@RequestParam Long id){
        return estudanteService.buscarPrimeirosEstudantes(id);
    }

}
