package com.linuxtips.descomplicandojavaespring.estudanteapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EstudanteDuplicadoException.class)
    public ResponseEntity<String> handleEstudanteDuplicadoException(EstudanteDuplicadoException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(EstudanteNaoEncontradoException.class)
    public ResponseEntity<String> handleEstudanteNaoEncontradoException(EstudanteNaoEncontradoException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
