package com.linuxtips.descomplicandojavaespring.day10.set;

import java.util.LinkedHashSet;

public class LinkedHashSetColletions {

    public static void main(String[] args) {

        // implementação de HashTable e lista vinculada da interface Set
        // herda de HashSet e implementa a interface Set
        // elementos devem ser únicos
        // mantem a ordem de inserção

        LinkedHashSet<String> linguagens = new LinkedHashSet<String>();
        linguagens.add("Java");
        linguagens.add("Python");
        linguagens.add("JavaScript");
        linguagens.add("C#");
        linguagens.add("C++");

        System.out.println(linguagens);

        // removendo um elemento da coleção
        linguagens.remove("C#");
        System.out.println(linguagens);

        // verificando se o elemento específico existe na coleção
        System.out.println(linguagens.contains("Java"));

    }

}
