package com.linuxtips.descomplicandojavaespring.day14.records;

public class Main {

    public static void main(String[] args) {

        DepoisDoRecord depoisDoRecord = new DepoisDoRecord("Luana", "Rua do Java", "999999999");
        System.out.println(depoisDoRecord.endereco());

        depoisDoRecord.telefone().equals("999999999");

    }

}
