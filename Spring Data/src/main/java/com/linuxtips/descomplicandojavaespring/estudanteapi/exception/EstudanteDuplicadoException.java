package com.linuxtips.descomplicandojavaespring.estudanteapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Estudante com o mesmo nome já cadastrado")
public class EstudanteDuplicadoException extends Exception {

    public EstudanteDuplicadoException() {
        super();
    }

    public EstudanteDuplicadoException(String message) {
        super(message);
    }

}
