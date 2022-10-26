package com.bepo.reactive.pokedex.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public class PokemonEvent {
    private Long id;
    private String type;
}
