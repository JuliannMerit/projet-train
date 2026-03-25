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

    public GareDTO() {

    }

    public GareDTO(Long idGare, String nomGare, String ville, int nombreQuais) {
        this.idGare = idGare;
        this.nomGare = nomGare;
        this.ville = ville;
        this.nombreQuais = nombreQuais;
    }

}
