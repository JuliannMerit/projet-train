package com.example.projettrain.dto;

import com.example.projettrain.entities.Habilitation;
import com.example.projettrain.entities.Train;

import java.util.List;

public class ConducteurDTP {
    private Long id;
    private String email;
    private String numeroTel;
    private Habilitation habilitation;
    private List<Train> trains;
}
