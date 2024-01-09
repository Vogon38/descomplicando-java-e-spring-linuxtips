package com.linuxtips.descomplicandojavaespring.day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ValidatorNotaFiscal {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/main/resources/nota-fiscal.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }



    }
}
