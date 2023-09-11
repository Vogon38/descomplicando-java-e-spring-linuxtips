package com.linuxtips.descomplicandojavaespring.day07.polimorfismo.sobrescrita;

public class BotaoTV extends Botao {

    @Override
    public void ligar() {
        System.out.println("Ligando a TV");
    }

    @Override
    public void desligar() {
        System.out.println("Chega de TV por hoje, bora descansar");
    }

}
