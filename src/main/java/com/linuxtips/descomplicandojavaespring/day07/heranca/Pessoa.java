package com.linuxtips.descomplicandojavaespring.day07.heranca;

public class Pessoa {

    public static void main(String[] args) {

        PessoaDesenvolvedoraBackEnd pessoaDesenvolvedoraBackEnd = new PessoaDesenvolvedoraBackEnd("Luana", "Java e Spring", 20000.0);
        pessoaDesenvolvedoraBackEnd.codar();

        PessoaDesenvolvedoraFrontEnd pessoaDesenvolvedoraFrontEnd = new PessoaDesenvolvedoraFrontEnd("Luana", "Javascripto", 20001.0);
        pessoaDesenvolvedoraFrontEnd.codar();

    }

}
