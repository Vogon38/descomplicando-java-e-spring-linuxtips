package com.linuxtips.descomplicandojavaespring.day03;

public class VariaveisETiposDeDados {

    public static void main(String[] args) {

        // valores inteiros ou negativos, requer 8 bits, máximo 127 e mínimo -128
        byte meuByte = 127;
        System.out.println("meu byte: " + meuByte);

        // o dobro de bit do byte, mínimo -32768 e máximo 32767
        short meuShort = 32767;
        System.out.println("meu short: " + meuShort);

        // usa 32 bits, mínimo -2147483648 e máximo 2147483647
        int idade = 25;
        System.out.println("meu int: " + idade);

        // 64 bits
        long meuLong = 10L;
        System.out.println("meu long: " + meuLong);

        // dupla precisao, 64 bits
        double salario = 102.51;
        System.out.println("meu salario double: " + salario);

        // precisao simples, 32 bits
        float salarioFloat = 102.51F;
        System.out.println("meu salario float: " + salarioFloat);

        // 16 bits, um unicode
        char letra = 'A';
        System.out.println("meu char: " + letra);

        // 1 bit
        boolean javaEhLegal = true;
        System.out.println("meu boolean: " + javaEhLegal);

    }

}
