package com.linuxtips.descomplicandojavaespring.day12;

public class Narrowing {

    public static void main(String[] args) {

        // nesse tipo de typecasting convertemos manualmente
        // um tipo de dados para outro usando o tipo desejado entre parenteses ()

        // double para int
        double variavelDouble = 10.5;
        System.out.println(variavelDouble);

        int variavelInt = (int) variavelDouble;
        System.out.println(variavelInt);

        // usamos quando queremos converter um tipo de dado maior para um menor
        // muitas vezes ocorre perda de dados
        // segue a ordem de conversao
        // byte ≤ short ≤ int ≤ long ≤ float ≤ double

        // int para string
        String minhaVariavelInt = String.valueOf(variavelInt);
        String minhaVariavelDouble = String.valueOf(variavelDouble);
        System.out.println(minhaVariavelInt);
        System.out.println(minhaVariavelDouble);

        String s = "1";
        // converter string para primitivo
        // usamos wrappers que empacotam os tipos primitivos
        boolean b = Boolean.parseBoolean(s);
        System.out.println(b);

        float f = Float.parseFloat(s);
        System.out.println(f);

        int i = Integer.parseInt(s);
        System.out.println(i);

        short sh = Short.parseShort(s);
        System.out.println(sh);

        long l = Long.parseLong(s);
        System.out.println(l);

        double d = Double.parseDouble(s);
        System.out.println(d);

        byte by = Byte.parseByte(s);
        System.out.println(by);

    }

}
