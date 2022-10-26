package com.bepo.reactive.pokedex.controller.request;

import com.bepo.reactive.pokedex.domain.PokemonType;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class PokemonRequest {

    @NotBlank
    private String name;
    @NotNull
    private PokemonType type;
    @NotNull
    private PokemonType weaknesses;
    @NotNull
    private Double weight;
    @NotNull
    private String ultimate;
}
