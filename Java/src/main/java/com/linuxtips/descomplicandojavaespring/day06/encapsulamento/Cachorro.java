package com.linuxtips.descomplicandojavaespring.day06.encapsulamento;

public class Cachorro {

    // so acessa dentro da classe
    private Double peso;
    private Integer idade;

    // o projeto inteiro tem acesso
    public Double pesoPublic;
    public Integer idadePublic;

    // so dentro do pacote
    protected Double pesoProtected;
    protected Integer idadeProtected;

    // o projeto inteiro acessa
    public String latir() {
        return "Au au";
    }

    // so o pacote acessa
    protected String dormir() {
        return "zzZzzzzzZz";
    }

    // so acessa dentro da classe
    private String comer() {
        return "Hora da ração";
    }

}
