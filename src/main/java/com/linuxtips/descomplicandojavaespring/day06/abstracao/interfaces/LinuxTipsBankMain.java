package com.linuxtips.descomplicandojavaespring.day06.abstracao.interfaces;

public class LinuxTipsBankMain {

    public static void main(String[] args) {

        System.out.println("Seja bem-vinde ao LinuxTips Bank");

        ContaCorrente ccLuana = new ContaCorrente();
        ccLuana.consultarSaldo();
        ccLuana.fazerPix();

        ContaPoupanca cpLuana = new ContaPoupanca();
        cpLuana.consultarSaldo();
        cpLuana.fazerPix();

    }

}
