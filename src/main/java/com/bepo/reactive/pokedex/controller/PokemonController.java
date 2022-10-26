package com.bepo.reactive.pokedex.controller;

import com.bepo.reactive.pokedex.controller.request.PokemonRequest;
import com.bepo.reactive.pokedex.domain.Pokemon;
import com.bepo.reactive.pokedex.domain.PokemonEvent;
import com.bepo.reactive.pokedex.mapper.PokemonMapper;
import com.bepo.reactive.pokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.Duration;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private static final int FIVE = 5;
    @Autowired
    private PokemonRepository repository;

    @GetMapping
    public Flux<Pokemon> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Pokemon>> getById(@PathVariable String id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Mono<Pokemon> savePokemon(@Valid @RequestBody PokemonRequest request) {
        return repository.save(PokemonMapper.toEntity(request));
    }

    @GetMapping(value = "/events", produces = TEXT_EVENT_STREAM_VALUE)
    public Flux<PokemonEvent> getEvents() {
        return Flux.interval(Duration.ofSeconds(FIVE))
                .map(val -> PokemonEvent.builder()
                        .id(val)
                        .type("A Event")
                        .build());
    }
}
