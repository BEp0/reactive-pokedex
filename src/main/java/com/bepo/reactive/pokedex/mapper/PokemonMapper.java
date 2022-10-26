package com.bepo.reactive.pokedex.mapper;

import com.bepo.reactive.pokedex.controller.request.PokemonRequest;
import com.bepo.reactive.pokedex.controller.response.PokemonResponse;
import com.bepo.reactive.pokedex.domain.Pokemon;

public class PokemonMapper {

    public static PokemonResponse toResponse(Pokemon pokemon) {
        return PokemonResponse.builder()
                .id(pokemon.getId())
                .name(pokemon.getName())
                .type(pokemon.getType())
                .weaknesses(pokemon.getWeaknesses())
                .weight(pokemon.getWeight())
                .ultimate(pokemon.getUltimate())
                .build();
    }

    public static Pokemon toEntity(PokemonRequest request) {
        return Pokemon.builder()
                .name(request.getName())
                .type(request.getType())
                .weaknesses(request.getWeaknesses())
                .weight(request.getWeight())
                .ultimate(request.getUltimate())
                .build();
    }
}
