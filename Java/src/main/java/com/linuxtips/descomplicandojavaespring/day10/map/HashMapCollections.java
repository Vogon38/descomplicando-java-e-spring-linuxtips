package com.linuxtips.descomplicandojavaespring.day10.map;

import java.util.HashMap;

public class HashMapCollections {

    public static void main(String[] args) {

        // armazena valores em pares chave-valor
        // chave -> índice
        // objeto -> valor
        // permite valores nulos
        // nao garante ordem

        HashMap<String, Double> notas = new HashMap<String, Double>();

        notas.put("Lógica de Programação", 7.0);
        notas.put("Banco de Dados", 8.0);
        notas.put("Java", 9.0);
        notas.put("POO", 10.0);
        System.out.println("Notas: " + notas);

        // exibe a nota da chave informada, case sensitive
        System.out.println(notas.get("Java"));

        // exibe se a chave informada existe
        System.out.println(notas.containsKey("Java"));

        // exibe o valor da chave informada e se nao existir exibe o valor default
        System.out.println(notas.getOrDefault("Java", 0.0));

        // adiciona um novo valor
        System.out.println(notas.put("Java", 8.5));

        // exibe se o valor informado existe
        System.out.println(notas.containsValue(9.5));



    }

}
