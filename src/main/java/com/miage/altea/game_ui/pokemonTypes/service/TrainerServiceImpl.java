package com.miage.altea.game_ui.pokemonTypes.service;

import com.miage.altea.game_ui.converter.TrainerToTrainerDTO;
import com.miage.altea.game_ui.dto.TrainerDTO;
import com.miage.altea.game_ui.pokemonTypes.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class TrainerServiceImpl implements TrainerService {

    RestTemplate restTemplate;
    String trainerServiceUrl;
    String trainerTypeUrl = "/trainers/";

    @Autowired
    private TrainerToTrainerDTO trainerToTrainerDTO;

    @Override
    public Iterable<Trainer> getAllTrainers() {
        return List.of(restTemplate.getForObject(trainerServiceUrl+trainerTypeUrl, Trainer[].class));
    }

    @Override
    public Iterable<TrainerDTO> getAllTrainersDTO() {
        List<TrainerDTO> trainers = trainerToTrainerDTO.getAllTrainersWithPokemonTypes(getAllTrainers());
        return trainers;
    }

    @Override
    public Trainer getTrainer(String name) {
        return  (restTemplate.getForObject(trainerServiceUrl+trainerTypeUrl+name, Trainer.class));
    }

    @Override
    public TrainerDTO getTrainerDTO(String name) {
        TrainerDTO trainer = trainerToTrainerDTO.getTrainerWithPokemonTypes(getTrainer(name));
        return trainer;
    }

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;}

    @Value("${trainer.service.url}")
    void setPokemonTypeServiceUrl(String trainerTypeUrl) {
        this.trainerServiceUrl = trainerTypeUrl;
    }
}
