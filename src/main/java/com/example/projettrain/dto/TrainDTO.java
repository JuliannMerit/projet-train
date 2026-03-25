package com.example.projettrain.dto;

import com.example.projettrain.entities.Conducteur;
import com.example.projettrain.entities.TypeMateriel;

public class TrainDTO {
    private Long id;
    private TypeMateriel type;
    private int nombrePlaces;
    private Conducteur conducteur;
}
