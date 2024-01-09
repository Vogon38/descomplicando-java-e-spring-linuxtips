package com.linuxtips.descomplicandojavaespring.day12.updowncasting;

public class AlimentarAnimais {

    // essa classe nao tem responsabilidade de saber qual animal vai ser alimentado
    // aqui usamos o polimorfismo

    public static void alimentar(Animal animal) {
        animal.comer();

        // so quero o downcasting se for cachorro
        if (animal instanceof Cachorro) {
            ((Cachorro) animal).latir();
        }

    }

}
