package com.linuxtips.descomplicandojavaespring.day10.Generic;

public class GenericMain {

    public static void main(String[] args) {

        GenericExample<Integer> mensagemInteger = new GenericExample<Integer>(200);
        mensagemInteger.escrever();

        GenericExample<Double> mensagemDouble = new GenericExample<Double>(200.0);
        mensagemDouble.escrever();

        GenericExample<String> mensagemString = new GenericExample<String>("LinuxTips");
        mensagemString.escrever();

    }


}
