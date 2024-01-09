package com.linuxtips.descomplicandojavaespring.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class NotaFiscal {

    public static void main(String[] args) throws IOException {

        System.out.println("Por favor, digite o código do produto:");

        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();

        System.out.println("Por favor, digite a quantidade do produto:");
        Integer quantidade = scanner.nextInt();

        System.out.println("Por favor, digite o valor do produto:");
        Integer valor = scanner.nextInt();

        int total = quantidade * valor;

        System.out.println("O total do pedido é: " + total);

        System.out.println("Aguarde um momento, estamos emitindo a sua nota fiscal...");

        Path fileName = Path.of("src/main/resources/nota-fiscal" + codigo +".txt");

        String text = "Código do produto: " + codigo +
                "\n" + "Quantidade do produto: " + quantidade +
                "\n" + "Valor do produto: " + valor +
                "\n" + "Total do pedido: " + total;

        Files.writeString(fileName, text);
        String fileContent = Files.readString(fileName);

        System.out.println(fileContent);

    }

}
