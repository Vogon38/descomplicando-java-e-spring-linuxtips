package com.linuxtips.descomplicandojavaespring.day14.streams;

import java.util.Arrays;
import java.util.List;

public class Reduce {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int listaReduzida = numbers.stream()
                // reduce -> reduz a lista a um único valor
                .reduce(0, Integer::sum);
        System.out.println(listaReduzida);
    }

}
