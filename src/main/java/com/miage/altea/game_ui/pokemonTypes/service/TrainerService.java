package com.miage.altea.game_ui.pokemonTypes.service;

import com.miage.altea.game_ui.dto.TrainerDTO;
import com.miage.altea.game_ui.pokemonTypes.bo.Trainer;

public interface TrainerService {

    Iterable<Trainer> getAllTrainers();
    Iterable<TrainerDTO> getAllTrainersDTO();
    Trainer getTrainer(String name);
    TrainerDTO getTrainerDTO(String name);
}
