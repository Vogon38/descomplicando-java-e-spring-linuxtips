package com.linuxtips.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    // requisições chegam aqui
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getCardapio() {
        return "Esse é o cardápio";
    }

}
