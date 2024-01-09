package com.linuxtips.descomplicandojavaespring.day10.queueJava;

import java.util.Comparator;

    public class EquipeComparator implements Comparator<Equipe> {

        @Override
        public int compare(Equipe equipe1, Equipe equipe2) {
            if(equipe1.saldoGols > equipe2.saldoGols) {
                return -1;
            } else if(equipe1.saldoGols < equipe2.saldoGols) {
                return 1;
            } else {
                return 0;
            }
        }

}
