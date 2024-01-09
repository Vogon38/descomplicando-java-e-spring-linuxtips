package com.linuxtips.descomplicandojavaespring.day10.queueJava;

public class Equipe {

    public String nome;
    public int saldoGols;

    public Equipe(String nome, int saldoGols) {
        this.nome = nome;
        this.saldoGols = saldoGols;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.saldoGols;
    }

}
