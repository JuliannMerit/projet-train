package com.example.projettrain.controllers;

import com.example.projettrain.dto.TrainDTO;
import com.example.projettrain.services.TrainService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/trains", produces = "application/json")
public class TrainController {
    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainDTO create(@Valid @RequestBody TrainDTO trainDTO) {
        return this.trainService.create(trainDTO);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainDTO updateConducteur(@PathVariable @NotNull(message = "Train's ID is required") Long id, @RequestBody TrainDTO trainDTO) {
        return this.trainService.updateConducteur(id, trainDTO.getConducteur());
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.GONE)
    public void remove(@RequestBody TrainDTO trainDTO) {
        this.trainService.remove(trainDTO);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainDTO getById(@PathVariable @NotNull(message = "Train's ID is required") Long id) {
        return this.trainService.getById(id);
    }
}
