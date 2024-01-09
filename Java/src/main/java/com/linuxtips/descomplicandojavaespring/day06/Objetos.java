package com.linuxtips.descomplicandojavaespring.day06;

public class Objetos {
    public static void main(String[] args) {

        Estudante luanacristini = new Estudante();

        luanacristini.setNome("Luana");
        luanacristini.setStack("Java e Spring");

        luanacristini.estudar();
        luanacristini.dormir();

//        System.out.println(luanacristini.getNome());
//        System.out.println(luanacristini.getStack());

    }

}
