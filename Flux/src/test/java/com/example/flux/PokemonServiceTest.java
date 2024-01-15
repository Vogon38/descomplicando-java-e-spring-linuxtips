package com.example.flux;

import com.example.flux.model.Pokemon;
import com.example.flux.repository.PokemonRepository;
import com.example.flux.service.PokemonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class PokemonServiceTest {

    @InjectMocks
    private PokemonService pokemonService;

    @Mock
    private PokemonRepository pokemonRepository;

    private final Pokemon pokemonMock = PokemonMock.pokemon();

    @BeforeEach
    public void setUp() {
        BDDMockito.when(pokemonRepository.save(PokemonMock.pokemon()))
                .thenReturn(Mono.just(pokemonMock));

        BDDMockito.when(pokemonRepository.findAll())
                .thenReturn(Flux.just(pokemonMock));

        BDDMockito.when(pokemonRepository.findById(ArgumentMatchers.anyString()))
                .thenReturn(Mono.just(pokemonMock));


        BDDMockito.when(pokemonRepository.delete(ArgumentMatchers.any(Pokemon.class)))
                .thenReturn(Mono.empty());
    }

    @Test
    @DisplayName("Deve criar um novo pokemon")
    public void deveCriarUmPokemonComSucesso() {
        StepVerifier.create(pokemonService.salvarPokemon(pokemonMock))
                .expectSubscription()
                .expectNext(pokemonMock)
                .verifyComplete();
    }

    @Test
    @DisplayName("Deve listar todos os pokemons")
    public void deveRetornarTodosPokemonsComSucesso() {
        StepVerifier.create(pokemonService.listarPokemons())
                .expectSubscription()
                .expectNext(pokemonMock)
                .verifyComplete();
    }

    @Test
    @DisplayName("Deve buscar e retornar um pokemon pelo id")
    public void deveBuscarPokemonPeloIdComSucesso() {
        StepVerifier.create(pokemonService.buscarPokemonPorId("a968b205-58a9-49dd-a0ca-279a54701759"))
                .expectSubscription()
                .expectNext(pokemonMock)
                .verifyComplete();
    }

    @Test
    @DisplayName("Deve excluir um pokemon com sucesso")
    public void deveExcluirUmPokemonComSucesso() {
        StepVerifier.create(pokemonService.excluirPokemonPorId("a968b205-58a9-49dd-a0ca-279a54701759"))
                .expectSubscription()
                .verifyComplete();
    }

    @Test
    @DisplayName("Deve retornar 404 quando não encontrar um pokemon")
    public void deveRetornar404QuandoNãoEncontrarPokemon() {
        BDDMockito.when(pokemonRepository.findById(ArgumentMatchers.anyString()))
                .thenReturn(Mono.empty());

        StepVerifier.create(pokemonService.buscarPokemonPorId("pokemon novo"))
                .expectSubscription()
                .expectError(ResponseStatusException.class)
                .verify();
    }

}
