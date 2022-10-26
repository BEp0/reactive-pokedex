package com.bepo.reactive.pokedex.controller.response;

import com.bepo.reactive.pokedex.domain.PokemonType;
import lombok.Builder;

@Builder
public class PokemonResponse {

    private String id;
    private String name;
    private PokemonType type;
    private PokemonType weaknesses;
    private Double weight;
    private String ultimate;
}
