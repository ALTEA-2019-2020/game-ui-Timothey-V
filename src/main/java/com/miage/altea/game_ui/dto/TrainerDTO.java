package com.miage.altea.game_ui.dto;

import com.miage.altea.game_ui.pokemonTypes.bo.Pokemon;
import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;

import java.util.List;

public class TrainerDTO {

    public String name;

    private List<PokemonDTO> team;

    public TrainerDTO(String name, List<PokemonDTO> team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonDTO> getTeam() {
        return team;
    }

    public void setTeam(List<PokemonDTO> team) {
        this.team = team;
    }
}
