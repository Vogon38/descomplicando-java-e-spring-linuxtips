package com.example.flux;

import com.example.flux.model.Pokemon;

import java.util.Collections;
import java.util.UUID;

public class PokemonMock {

    public static Pokemon pokemon(){
        return new Pokemon("a968b205-58a9-49dd-a0ca-279a54701759","Mewtwo","psychic", Collections.emptyList());
    }
}
