package com.bepo.reactive.pokedex.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public class Pokemon {

    @Id
    private String id;
    private String name;
    private PokemonType type;
    private PokemonType weaknesses;
    private Double weight;
    private String ultimate;

}
