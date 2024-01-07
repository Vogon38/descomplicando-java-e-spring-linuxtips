package com.linuxtips.descomplicandojavaespring.day12.updowncasting;

import java.util.ArrayList;
import java.util.List;

import static com.linuxtips.descomplicandojavaespring.day12.updowncasting.AlimentarAnimais.alimentar;

public class updowncastingMain {

    public static void main(String[] args) {

        Passaro passaro = new Passaro();
        passaro.comer();

        List<Animal> animais = new ArrayList<>();
        animais.add(new Passaro());
        animais.add(new Cachorro());

        for (Animal animal : animais) {
            alimentar(animal);
        }

        Animal animal = new Cachorro();
        alimentar(animal);

    }

}
