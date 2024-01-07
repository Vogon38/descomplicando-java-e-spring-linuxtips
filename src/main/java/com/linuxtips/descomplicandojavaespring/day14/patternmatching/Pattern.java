package com.linuxtips.descomplicandojavaespring.day14.patternmatching;

public class Pattern {

    // veio no Java 17, no 19 third preview
    // confere se o tipo também se encaixa no pattern especificado

    static double transformaEmDouble(Object number) {
        return switch (number) {
            case Integer i -> i.doubleValue();
            case Float f -> f.doubleValue();
            case String s -> Double.parseDouble(s);

            default -> 0d;
        };

    }

}
