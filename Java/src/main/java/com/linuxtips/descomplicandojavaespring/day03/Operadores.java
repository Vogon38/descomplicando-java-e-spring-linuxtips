package com.linuxtips.descomplicandojavaespring.day03;

public class Operadores {

    public static void main(String[] args) {

        // operador de atribuicao
        int idade = 25;
        System.out.println("valor atribuído a idade " + idade);

        // operadores matematicos
        int soma = idade + 5;
        System.out.println("resultado da soma " + soma);

        int multiplicacao = soma * 2;
        System.out.println("resultado da multiplicacao " + multiplicacao);

        int divisao = multiplicacao / 2;
        System.out.println("resultado da divisao " + divisao);

        int modulo = divisao % 4;
        System.out.println("resultado do modulo " + modulo);

        // incremento e decremento
        int incremento = 15;
        System.out.println("valor original antes do incremento " + incremento);
        incremento++;
        System.out.println("valor apos o incremento " + incremento);

        int decremento = 20;
        System.out.println("valor original antes do incremento " + decremento);
        decremento--;
        System.out.println("valor apos o incremento " + decremento);

        // operadores de igualdade
        long valor1 = 1L;
        long valor2 = 2L;

        if(valor1 == valor2) {
            System.out.println("valores sao iguais");
        } else {
            System.out.println("valores diferentes");
        }

        double valor3 = 10.2;
        double valor4 = 100.2;

        if(valor3 != valor4) {
            System.out.println("valores diferentes");
        } else {
            System.out.println("valores sao iguais");
        }

        // operadores relacionais
        int primeiroValor = 1234;
        int segundoValor = 12345;

        if(primeiroValor > segundoValor) {
            System.out.println(primeiroValor + " é maior que " + segundoValor);
        } if(primeiroValor >= segundoValor) {
            System.out.println(primeiroValor + " é maior ou igual " + segundoValor);
        } if(primeiroValor < segundoValor) {
            System.out.println(primeiroValor + " é menor que " + segundoValor);
        } if(primeiroValor <= segundoValor) {
            System.out.println(primeiroValor + " é menor ou igual " + segundoValor);
        }

        // operadores logicos
        boolean verdadeiro = true;
        boolean falso = false;

        System.out.println(verdadeiro || falso);
        System.out.println(verdadeiro && falso);

    }

}
