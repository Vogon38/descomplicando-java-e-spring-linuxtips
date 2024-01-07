package com.linuxtips.descomplicandojavaespring.day14.textblocks;

public class TextBlocksExample {

    public static void main(String[] args) {

        // antes do Java 15
        String sqlAntesDoJava15 =
                "SELECT id, nome sobrenome\n"
                + "FROM estudante\n"
                + "WHERE linguagem = \"Java\"\n"
                + "ORDER BY nome, sobrenome";
        System.out.println(sqlAntesDoJava15);

        // a partir do Java 15
        String sqlAposDoJava15 = """
                SELECT id, nome sobrenome
                FROM estudante
                WHERE linguagem = "Java"
                ORDER BY nome, sobrenome""";
        System.out.println(sqlAposDoJava15);

    }


}
