package com.linuxtips.descomplicandojavaespring.day10.queueJava;

import java.util.PriorityQueue;

public class PriorityQueueMain {

    public static void main(String[] args) {

        Equipe equipe1 = new Equipe("Equipe 1", 10);
        Equipe equipe2 = new Equipe("Equipe 2", 5);
        Equipe equipe3 = new Equipe("Equipe 3", 15);
        Equipe equipe4 = new Equipe("Equipe 4", 0);
        Equipe equipe5 = new Equipe("Equipe 5", 20);

        PriorityQueue<Equipe> priorityQueue = new PriorityQueue<Equipe>(5, new EquipeComparator());
        priorityQueue.add(equipe1);
        priorityQueue.add(equipe2);
        priorityQueue.add(equipe3);
        priorityQueue.add(equipe4);
        priorityQueue.add(equipe5);

        for (Equipe equipe : priorityQueue) {
            System.out.println(equipe);
        }

        // retornando a lista em ordem de pontuação
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

    }

}
