package com.linuxtips.descomplicandojavaespring.day04;

import java.util.Scanner;

public class Repeticao {

    public static void main(String[] args) {

        // for
        for (int i = 0; i <= 100; i ++) {
            System.out.println("Nessa repetição i está valendo: " + i);
        }

        //while
        Scanner in = new Scanner(System.in);
        var valorSecreto = 0;

        while (valorSecreto != 12345) {
            System.out.println("Adivinhe o valor secreto:");
            valorSecreto = in.nextInt();
            if (valorSecreto == 12345) {
                System.out.println("Parabéns, você acertou o valor secreto!");
            } else {
                System.out.println("Ops, não é esse o valor. Tente novamente.");
            }
        }

        // do-while
        int valor = 10;

        do {
            System.out.println(valor);
            valor++;
        } while (valor <= 50);

    }

}
