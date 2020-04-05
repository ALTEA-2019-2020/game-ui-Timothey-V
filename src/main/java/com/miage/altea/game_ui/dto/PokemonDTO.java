package com.miage.altea.game_ui.dto;

import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;

public class PokemonDTO {

    public int level;
    public PokemonType pokemonType;

    public PokemonDTO(int level, PokemonType pokemonType) {
        this.level = level;
        this.pokemonType = pokemonType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }
}
