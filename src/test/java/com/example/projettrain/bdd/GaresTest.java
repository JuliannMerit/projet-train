package com.example.projettrain.bdd;

import com.example.projettrain.entities.Gares;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GaresTest {

    @Test
    public void creeDesInstancesDansLaTableGares(){
        Gare tableGares = Gare.builder()
                .nomGare("Nantes Est")
                .ville("Nantes")
                .nombreQuais(5)
                .build();
        tableGares.setNomGare("Nantes Est");
        tableGares.setVille("Nantes");
        tableGares.setNombreQuais(5);
        assertThat(tableGares.getNomGare()).isEqualTo("Nantes Est");
    }
}
