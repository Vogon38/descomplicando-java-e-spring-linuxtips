package com.linuxtips.descomplicandojavaespring.day14.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedAndForEach {

    public static void main(String[] args) {

        List<String> unsorted = Arrays.asList("z", "x", "y", "a", "b", "c");
        System.out.println(unsorted);

        // sorted -> ordena a lista array/stream
        List<String> sorted = unsorted.stream().sorted().toList();

        // forEach -> percorre a lista array/stream
        sorted.forEach(System.out::println);

    }

}
