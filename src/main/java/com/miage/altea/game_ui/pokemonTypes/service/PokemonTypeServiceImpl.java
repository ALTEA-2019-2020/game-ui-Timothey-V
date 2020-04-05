package com.miage.altea.game_ui.pokemonTypes.service;

import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{
    RestTemplate restTemplate;
    String pokemonServiceUrl;
    String pokemonTypeUrl = "/pokemon-types/";

    public List<PokemonType> listPokemonsTypes() {
        return List.of(restTemplate.getForObject(pokemonServiceUrl+pokemonTypeUrl,PokemonType[].class));
    }

    public PokemonType getPokemon(int id) {
        return restTemplate.getForObject(pokemonServiceUrl + pokemonTypeUrl+id, PokemonType.class);
    }

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}
