package com.bepo.reactive.pokedex.repository;

import com.bepo.reactive.pokedex.domain.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PokemonRepository extends ReactiveMongoRepository<Pokemon, String> {
}
