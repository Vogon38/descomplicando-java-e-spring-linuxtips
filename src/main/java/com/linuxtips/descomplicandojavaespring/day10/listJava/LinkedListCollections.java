package com.linuxtips.descomplicandojavaespring.day10.listJava;

import java.util.LinkedList;

public class LinkedListCollections {

    public static void main(String[] args) {
        // igual ao ArrayList, mas com a diferença que o LinkedList é mais rápido para adicionar e remover elementos

        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int i = 1; i <= 10; i++) {
            linkedList.add(i);
        }

        System.out.println(linkedList);

        // removendo o primeiro elemento
        System.out.println(linkedList.pop());
        System.out.println(linkedList);

        // retornando o primeiro elemento sem removê-lo
        System.out.println(linkedList.peek());
        System.out.println(linkedList);

        // retornando e removendo o primeiro elemento
        System.out.println(linkedList.poll());
        System.out.println(linkedList);

        // limpa a lista
        linkedList.clear();

    }
}
