package com.miage.altea.game_ui.pokemonTypes.service;

import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonTypeServiceImpl {

    public List<PokemonType> listPokemonsTypes() {
        return null;
    }

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {

    }

    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {

    }
}
