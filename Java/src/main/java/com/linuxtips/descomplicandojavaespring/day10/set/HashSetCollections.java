package com.linuxtips.descomplicandojavaespring.day10.set;

import java.util.HashSet;

public class HashSetCollections {

    public static void main(String[] args) {

        // coleção de itens onde cada item é único
        // implementa a interface Set
        // objetos são inseridos com base em seus hashcodes
        // elementos null são permitidos

        HashSet<String> linguagens = new HashSet<String>();
        linguagens.add("Java");
        linguagens.add("Python");
        linguagens.add("JavaScript");
        linguagens.add("C#");
        linguagens.add("C++");

        System.out.println(linguagens);

        // verificando se o elemento específico existe na coleção
        System.out.println(linguagens.contains("Java"));

        // verificando o tamanho da coleção
        System.out.println(linguagens.size());

        // interando sobre a coleção
        for (String linguagem : linguagens) {
            System.out.println(linguagem);
        }

    }

}
