package com.linuxtips.descomplicandojavaespring.day14.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample {

    public static void main(String[] args) {

        // pequeno bloco de codigo que recebe um parametro e retorna um valor
        // são semelhantes a metodos, porem não precisam de um nome e podem ser implementados diretamente em outro metodo

        List<String> curso = Arrays.asList("Java", "PHP", "Python", "C#", "C++", "JavaScript", "Ruby", "Go", "Swift", "Kotlin");
        List<String> java = curso.stream().filter(s -> s.equals("Java"))
                .collect(Collectors.toList());
        System.out.println(java);

    }

}
