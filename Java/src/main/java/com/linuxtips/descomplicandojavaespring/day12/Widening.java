package com.linuxtips.descomplicandojavaespring.day12;

public class Widening {

    public static void main(String[] args) {

        int variavelInt = 10;
        long variavelLong = variavelInt;

        System.out.println(variavelInt);
        System.out.println(variavelLong);

        // no tipo de conversao o valor é armazenado em um container maior
        // o espaço extra existente a esquerda é preenchido com zeros

        // quando passamos valores inteiros para variaveis do tipo float ou double ocorre o mesmo
        float variavelFloat = variavelLong;

        // nao ocorre perca de dados
        double variavelDouble = variavelLong;

        System.out.println(variavelFloat);
        System.out.println(variavelDouble);

        // para espaço maior nao ocorre perda de dado
        // byte ≥ short ≥ int ≥ long ≥ float ≥ double

    }
}
