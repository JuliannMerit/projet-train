package com.example.projettrain.services;

import com.example.projettrain.dto.TrainDTO;
import com.example.projettrain.entities.Conducteur;
import com.example.projettrain.entities.Train;
import com.example.projettrain.repositorys.TrainRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
    private final TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public TrainDTO create(TrainDTO trainDTO) {
        final var trainEntityBuilder = Train.builder()
                .type(trainDTO.getType())
                .nombrePlace(trainDTO.getNombrePlaces());

        final var createdTrainEntity = this.trainRepository.save(trainEntityBuilder.build());
        return this.entityToDto(createdTrainEntity);
    }

    private TrainDTO entityToDto(Train trainEntity) {
        return TrainDTO.builder()
                .id(trainEntity.getId())
                .type(trainEntity.getType())
                .nombrePlaces(trainEntity.getNombrePlace())
                .conducteur(trainEntity.getConducteur())
                .build();
    }

    public TrainDTO getById(Long id) {
        Train trainEntity = this.trainRepository.findById(id).orElseThrow(() -> new RuntimeException("Train not found"));
        return this.entityToDto(trainEntity);
    }

    public TrainDTO updateConducteur(Long id, Conducteur conducteur){
        final var trainEntity = this.trainRepository.findById(id).orElseThrow(() -> new RuntimeException("Train not found"));
        trainEntity.setConducteur(conducteur);
        final var updatedTrainEntity = this.trainRepository.save(trainEntity);
        return this.entityToDto(updatedTrainEntity);
    }

    public void remove(TrainDTO trainDTO){
        final var trainEntity = this.trainRepository.findById(trainDTO.getId()).orElseThrow(() -> new RuntimeException("Train not found"));
        this.trainRepository.delete(trainEntity);
    }
}
