package com.linuxtips.descomplicandojavaespring.day10.listJava;

import java.util.Vector;

public class VectorListCollections {

    public static void main(String[] args) {

        // também muito semelhante ao ArrayList, porém é sincronizado, mais thread-safe
        // alocação dinâmica -> aumenta 100% do tamanho quando chega no limite

        Vector<Integer> vetor = new Vector<Integer>();

        for(int i = 1; i <= 10; i++) {
            vetor.add(i);
        }

        System.out.println(vetor);

        // retornando o valor do índice 2
        System.out.println(vetor.elementAt(2));

        // retornando o primeiro elemento
        System.out.println(vetor.firstElement());

        // adicionando elemento
        System.out.println(vetor.add(20));

        // adicionando elemento em uma posição específica
        vetor.add(2, 30);

        System.out.println(vetor);

    }

}
