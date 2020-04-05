package com.miage.altea.game_ui.converter;

import com.miage.altea.game_ui.dto.PokemonDTO;
import com.miage.altea.game_ui.dto.TrainerDTO;
import com.miage.altea.game_ui.pokemonTypes.bo.Pokemon;
import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.game_ui.pokemonTypes.bo.Trainer;
import com.miage.altea.game_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.game_ui.pokemonTypes.service.PokemonTypeServiceImpl;
import com.miage.altea.game_ui.pokemonTypes.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TrainerToTrainerDTO {

    @Autowired
    public PokemonTypeService pokemonTypeService;

    public TrainerDTO getTrainerWithPokemonTypes(Trainer trainer) {
        List<PokemonDTO> allPokemonTypes = new ArrayList<PokemonDTO>();
        for (Pokemon p:trainer.getTeam()) {
            PokemonType pokemonType = pokemonTypeService.getPokemon(p.getPokemonTypeId());
            allPokemonTypes.add(new PokemonDTO(p.getLevel(),pokemonType));
        }
        TrainerDTO newTrainer = new TrainerDTO(trainer.getName(),allPokemonTypes);
        return newTrainer;
    }

    public List<TrainerDTO> getAllTrainersWithPokemonTypes(Iterable<Trainer> allTrainers) {
        List<TrainerDTO> trainers = new ArrayList<TrainerDTO>();
        for (Trainer t: allTrainers) {
            trainers.add(getTrainerWithPokemonTypes(t));
        }
        return trainers;
    }
}
