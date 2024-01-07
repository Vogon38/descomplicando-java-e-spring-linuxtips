package com.linuxtips.descomplicandojavaespring.day11;

public class toStringMain {

    public static void main(String[] args) {

        Funcionaria funcionaria = new Funcionaria();
        funcionaria.setIdade(25);
        funcionaria.setNome("Maria");
        funcionaria.setCargo("Analista de Sistemas");
        funcionaria.setSalario(5000.00);
        funcionaria.setSetor("TI");

//        System.out.println(funcionaria);

//        System.out.println(funcionaria.hashCode());
//        System.out.println(funcionaria.getSalario().hashCode());
//        System.out.println(funcionaria.getNome().hashCode());
//        System.out.println(funcionaria.getSetor().hashCode());
//        System.out.println(funcionaria.getCargo().hashCode());
//        System.out.println(funcionaria.getIdade().hashCode());

        var setorHashCode = String.valueOf(funcionaria.getSetor().hashCode());
        var setorHashCode2 = String.valueOf("ti".hashCode());

        System.out.println(setorHashCode.equals(setorHashCode2));

    }

}
