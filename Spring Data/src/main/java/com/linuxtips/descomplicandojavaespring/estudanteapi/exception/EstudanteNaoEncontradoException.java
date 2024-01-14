package com.linuxtips.descomplicandojavaespring.estudanteapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Estudante não encontrado")
public class EstudanteNaoEncontradoException extends Exception {

    public EstudanteNaoEncontradoException() {
        super();
    }

    public EstudanteNaoEncontradoException(Long id) {
        super("Estudante com o id " + id + " não encontrado");
    }


}
