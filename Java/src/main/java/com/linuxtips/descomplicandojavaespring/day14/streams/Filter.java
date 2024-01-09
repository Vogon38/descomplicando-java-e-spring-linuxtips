package com.linuxtips.descomplicandojavaespring.day14.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {

        // filter() é uma operação intermediária que retorna um fluxo de elementos que atendem a um filtro indicado
        List<String> curso = Arrays.asList("Java", "C#", "Python", "JavaScript", "PHP", "C++", "Ruby", "Go", "Swiftes", "Kotlin");
        List<String> terminaComS = curso.stream().filter(s -> s.endsWith("s"))
                .collect(Collectors.toList());
        System.out.println(terminaComS);

    }

}
