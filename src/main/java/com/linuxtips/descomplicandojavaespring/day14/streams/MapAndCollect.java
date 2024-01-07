package com.linuxtips.descomplicandojavaespring.day14.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndCollect {

    public static void main(String[] args) {

        List<String> listaString = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        System.out.println(listaString);

        List<Integer> listaInteger = listaString.stream()
                // visa retornar um stream com o resultado de uma operação que foi realizada com cada elemento do stream anterior
                .map(Integer::valueOf)
                // para coletar o resultado das transformações feitas em um fluxo
                .collect(Collectors.toList());
        System.out.println(listaInteger);

    }

}
