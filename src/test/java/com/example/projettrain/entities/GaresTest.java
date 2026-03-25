package com.example.projettrain.entities;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GaresTest {

    @Test
    public void verifieGettersEtSetters(){
        Gares tableGares = new Gares();
        tableGares.setIdGare(1234L);
        tableGares.setNomGare("Nantes Est");
        tableGares.setVille("Nantes");
        tableGares.setNombreQuais(5);

        assertThat(tableGares.getIdGare()).isEqualTo(1234L);
        assertThat(tableGares.getNomGare()).isEqualTo("Nantes Est");
        assertThat(tableGares.getVille()).isEqualTo("Nantes");
        assertThat(tableGares.getNombreQuais()).isEqualTo(5);
    }
}
