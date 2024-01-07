package com.linuxtips.descomplicandojavaespring.day10.listJava;

import java.util.ArrayList;

public class ArrayListCollections {

    public static void main(String[] args) {

        // nos fornece arrays dinamicos
        // pode ser mais lento que o array normal
        // aumenta 50% do tamanho do array quando chega no limite
        // quando aumenta o tamanho do array, ele copia o array antigo para o novo

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        // adicionando elementos no array
        for(int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }

        // removendo elementos do array
        arrayList.remove(1);
        System.out.println(arrayList);

        // obtendo elementos do índice
        System.out.println(arrayList.get(3));

        // retornando se está vazio
        System.out.println(arrayList.isEmpty());

        // procurando um número específico
        System.out.println(arrayList.contains(5));

        // copiando um array para outro
        System.out.println(arrayList.clone());

        // retornando o índice da primeira ocorrência do elemento especificado
        System.out.println(arrayList.indexOf(5));

        // limpando o array
        arrayList.clear();

    }

}
