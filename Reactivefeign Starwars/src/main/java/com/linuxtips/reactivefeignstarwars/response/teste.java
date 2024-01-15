package com.linuxtips.reactivefeignstarwars.response;

import java.util.HashMap;
import java.util.Map;

public class teste {
    public static void main(String[] args) {
        // Opção 1: Usando inferência de tipo (Diamond Operator)
        Map<String, Double> notas1 = new HashMap<>();
        notas1.put("Logica de programacao", 7.8);

        // Opção 2: Especificando tipos explicitamente
        HashMap<String, Double> notas2 = new HashMap<>();
        notas2.put("Logica de programacao", 7.8);

        // Opção 3: Usando a interface Map para referenciar a implementação HashMap
        Map<String, Double> notas3 = new HashMap<>();
        notas3.put("Logica de programacao", 7.8);
    }
}