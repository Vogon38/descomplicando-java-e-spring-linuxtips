package com.linuxtips.descomplicandojavaespring.day10;

public class ClasseAninhada {

    private ClasseAninhada() {
        System.out.println("Construtor da classe aninhada");
    }

    private static class ClasseRealmenteAninhada{
        public static final ClasseAninhada classeAninhada = new ClasseAninhada();
    }

    public static ClasseAninhada getInstancia(){
        return ClasseRealmenteAninhada.classeAninhada;
    }

}
