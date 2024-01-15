package com.example.flux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection= "pokemons")
public record Pokemon(@Id String id, String name, String type, List<String> evolutions) {



}
