package com.linuxtips.descomplicandojavaespring.day14.virtualThreads;

import java.util.Random;

public class VirtualThreads {

    public static void main(String[] args) {

        // flag que controla o uso de threads virtuais
        boolean useVirtualThreads = true;
        System.out.println("Threads virtuais ligadas? " + useVirtualThreads);

        long horaInicio = System.currentTimeMillis();

        Random random = new Random();
        // cria uma runnable para conseguir numeros aleatorios ate o valor de bound
        Runnable runnable = () -> {
            Integer i = random.nextInt(999);
        };

        for (int i = 0; i < 100; i++) {
            if (useVirtualThreads) {
                // cria uma thread virtual
                Thread.startVirtualThread(runnable);
            } else {
                // cria uma thread normal
                new Thread(runnable).start();
            }
        }

        long horaFim = System.currentTimeMillis();
        long tempoTotal = horaFim - horaInicio;
        System.out.println("Tempo gasto em execução: " + tempoTotal + "ms");

    }

}
