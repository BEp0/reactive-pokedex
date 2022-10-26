package com.bepo.reactive.pokedex.bean;

import com.bepo.reactive.pokedex.domain.CreateStartFlux;
import com.bepo.reactive.pokedex.domain.Pokemon;
import com.bepo.reactive.pokedex.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.core.publisher.Flux;

//@Component
public class CommandLineBean {
    @Bean
    CommandLineRunner init(ReactiveMongoOperations operations, PokemonRepository repository) {
        return args -> {
            Flux<Pokemon> pokemonFlux = CreateStartFlux
                    .getFlux()
                    .flatMap(repository::save);

            pokemonFlux
                    .thenMany(repository.findAll())
                    .subscribe(System.out::println);

        };
    }
}
