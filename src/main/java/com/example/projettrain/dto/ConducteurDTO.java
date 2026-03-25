package com.example.projettrain.dto;

import com.example.projettrain.entities.Habilitation;
import com.example.projettrain.entities.Train;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ConducteurDTO {
    @NotNull
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String numeroTel;
    @NotNull
    private Habilitation habilitation;
    @NotNull
    private List<Train> trains;

    public ConducteurDTO(){

    }

    public ConducteurDTO(String email, String numeroTel, Habilitation habilitation) {
        this.email = email;
        this.numeroTel = numeroTel;
        this.habilitation = habilitation;
    }
}