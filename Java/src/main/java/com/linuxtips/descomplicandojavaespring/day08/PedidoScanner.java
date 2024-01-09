package com.linuxtips.descomplicandojavaespring.day08;

import java.util.Scanner;

public class PedidoScanner {

    public static void main(String[] args) {
        System.out.println("Por favor, digite o código do produto:");

        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();

        System.out.println("Por favor, digite a quantidade do produto:");
        Integer quantidade = scanner.nextInt();

        System.out.println("Por favor, digite o valor do produto:");
        Integer valor = scanner.nextInt();

        int total = quantidade * valor;

        System.out.println("O total do pedido é: " + total);

    }

}
