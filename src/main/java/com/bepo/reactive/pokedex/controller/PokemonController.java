package com.bepo.reactive.pokedex.controller;

import com.bepo.reactive.pokedex.controller.request.PokemonRequest;
import com.bepo.reactive.pokedex.domain.Pokemon;
import com.bepo.reactive.pokedex.mapper.PokemonMapper;
import com.bepo.reactive.pokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

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
}
