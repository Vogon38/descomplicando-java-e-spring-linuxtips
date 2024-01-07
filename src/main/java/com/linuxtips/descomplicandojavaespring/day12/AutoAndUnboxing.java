package com.linuxtips.descomplicandojavaespring.day12;

public class AutoAndUnboxing {

    public static void main(String[] args) {

        // autoboxing coverte um tipo primitivo em um objeto wrapper correspondente
        int variavelInt = 10;
        Integer variavelInteger = variavelInt;

        System.out.println(variavelInteger);

        // unboxing coverte um objeto wrapper em um tipo primitivo correspondente
        Integer wrapperInteger = 13;
        int primitivoInteger = wrapperInteger;

        System.out.println(primitivoInteger);

    }

}
