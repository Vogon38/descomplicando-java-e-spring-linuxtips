package com.linuxtips.descomplicandojavaespring.day05;

import java.util.Arrays;
import java.util.List;

public class Array {

    public static void main(String[] args) {

        // estrutura de dados simples para armazenar uma coleção de elementos

        // forma mais comum de declarar arrays
        int[] arrayDeInt;

        // forma menos comum
        int[] arrayDeInt2[];

        // inicializando um array - caso já saiba o número de elementos
        int[] arrayDeInt3 = new int[20];

        // preenchendo o array
        Integer[] arrayDeInt4 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // descobrindo o tamanho do array
        int arraySize = arrayDeInt4.length;
        System.out.println("O tamanho do meu array é: " + arraySize);

        // percorrendo o array
        List<Integer> itens = Arrays.asList(arrayDeInt4);
        itens.forEach(System.out::println);

        // copiando um array - copyOfRange
        String[] treinamento = new String[] {
                "treinamento",
                "descomplicando",
                "java",
                "e",
                "spring",
                "da",
                "linux",
                "tips"
        };

        String[] treinamentoNome = Arrays.copyOfRange(treinamento, 1, 5);
        List<String> treinamentoNomeList = List.of(treinamentoNome);
        treinamentoNomeList.forEach(System.out::println);

        //preenchendo um array
        String[] java = new String[10];
        Arrays.fill(java, "java");
        List<String> javaList = List.of(java);
        javaList.forEach(System.out::println);

        int[] arrayDeInt5 = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

        int[] arrayDeInt6 = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

        System.out.println("OS arrays são iguais? " +
                Arrays.equals(arrayDeInt5, arrayDeInt6));

        //sorted
        String[] sorted = Arrays.copyOf(treinamento, 8);
        Arrays.sort(sorted);
        List<String> sortedList = List.of(sorted);
        sortedList.forEach(System.out::println);

    }

}
