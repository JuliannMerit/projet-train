package com.example.projettrain.dto;

import jakarta.validation.constraints.NotNull;

public class GareDTO {

    @NotNull
    private Long idGare;
    @NotNull
    private String nomGare;
    @NotNull
    private String ville;
    @NotNull
    private int nombreQuais;
}
