package com.example.flux.service;

import com.example.flux.model.Pokemon;
import com.example.flux.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Mono<Pokemon> salvarPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Flux<Pokemon> listarPokemons() {
        return pokemonRepository.findAll();
    }

    public Mono<Pokemon> buscarPokemonPorId(String id) {
        return pokemonRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(NOT_FOUND, "Pokemon not found")));
    }

    public Mono<ResponseEntity<Pokemon>> atualizarPokemonPorId(String id, Pokemon pokemon) {
        return pokemonRepository.findById(id)
                .flatMap(pokemonBase ->
                        pokemonRepository.save(new Pokemon(
                                id, pokemon.name(), pokemon.type(), pokemon.evolutions())))
                .map(pokemonAtualizado -> new ResponseEntity<>(pokemonAtualizado, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public Mono<Void> excluirPokemonPorId(String id) {
        return pokemonRepository.findById(id)
                .flatMap(pokemonRepository::delete);
    }


}
