package com.example.projettrain.dto;

import com.example.projettrain.entities.Conducteur;
import com.example.projettrain.entities.TypeMateriel;
import jakarta.validation.constraints.NotNull;

public class TrainDTO {
    @NotNull
    private Long id;
    @NotNull
    private TypeMateriel type;
    @NotNull
    private int nombrePlaces;
    @NotNull
    private Conducteur conducteur;
}
