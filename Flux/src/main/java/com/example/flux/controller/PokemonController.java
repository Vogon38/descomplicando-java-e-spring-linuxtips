package com.example.flux.controller;

import com.example.flux.model.Pokemon;
import com.example.flux.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Pokemon> criarPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.salvarPokemon(pokemon);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Pokemon> listarPokemons() {
        return pokemonService.listarPokemons();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Pokemon> buscarPokemonPeloId(@PathVariable String id) {
        return pokemonService.buscarPokemonPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Pokemon>> atualizarPokemon(@PathVariable(value = "id") String id,
                                                          @RequestBody Pokemon pokemon) {
        return pokemonService.atualizarPokemonPorId(id, pokemon);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> atualizarPokemonPeloId(@PathVariable String id) {
        return pokemonService.excluirPokemonPorId(id);
    }

}
