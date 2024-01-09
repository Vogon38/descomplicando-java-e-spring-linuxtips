package com.linuxtips.descomplicandojavaespring.day10.generic;

public class GenericExample<T> {

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public GenericExample(T mensagem) {
        this.name = mensagem;
    }

    T name;

    public void escrever() {
        System.out.println(name);
    }



}
