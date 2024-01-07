package com.linuxtips.descomplicandojavaespring.day10.map;

import java.util.HashMap;
import java.util.Hashtable;

public class HashTableCollections {

    public static void main(String[] args) {

        // armazena valores em pares chave-valor
        // nao permite valores nulos
        // nao permite valores duplicados
        // nao garante ordem

        Hashtable<String, Double> notas = new Hashtable<String, Double>();

        notas.put("Lógica de Programação", 7.0);
        notas.put("Java", 9.0);
        notas.put("POO", 10.0);
        System.out.println("Notas: " + notas);
        System.out.println("Só as notas: " + notas.values());
        System.out.println(notas.replace("Java", 10.0));
        System.out.println("Notas: " + notas);

        // inserir apenas se a chave nao existir
        System.out.println(notas.putIfAbsent("Banco de dados", 9.0));
        System.out.println("Notas: " + notas);

    }

}
