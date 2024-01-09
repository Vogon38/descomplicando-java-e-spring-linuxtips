package com.linuxtips.descomplicandojavaespring.day13.unchecked;

public class ArrayIndexOutOfBoundsExample {

    public static void main(String[] args) {

        try {
            int[] array = {1, 2, 3, 4, 5};
            System.out.println(array[50]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Não foi possível acessar o índice requerido, erro: {[" + e.getMessage() + "]}");
        } finally {
            System.out.println("Passou pelo finally");
        }

    }

}
