package com.bepo.reactive.pokedex.domain;

import reactor.core.publisher.Flux;

import static com.bepo.reactive.pokedex.domain.PokemonType.*;

public class CreateStartFlux {
    public static Flux<Pokemon> getFlux(){
        return Flux.just(
                Pokemon.builder()
                        .id(null)
                        .name("Pikachu")
                        .type(ELETRIC)
                        .weaknesses(GROUND)
                        .weight(6.0)
                        .ultimate("Thunder Wave")
                        .build(),
                Pokemon.builder()
                        .id(null)
                        .name("Chimchar")
                        .type(FIRE)
                        .weaknesses(WATER)
                        .weight(6.2)
                        .ultimate("Blaze")
                        .build(),
                Pokemon.builder()
                        .id(null)
                        .name("Vaporeon")
                        .type(WATER)
                        .weaknesses(ELETRIC)
                        .weight(29.0)
                        .ultimate("Water Absorb")
                        .build(),
                Pokemon.builder()
                        .id(null)
                        .name("Dugtrio")
                        .type(GROUND)
                        .weaknesses(WATER)
                        .weight(33.3)
                        .ultimate("Sand Veil")
                        .build()
        );
    }
}
