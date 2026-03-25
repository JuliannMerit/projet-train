package com.example.projettrain.entities;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GareTest {

    @Test
    public void verifieGettersEtSetters(){
        Gare tableGare = new Gare();
        tableGare.setIdGare(1234L);
        tableGare.setNomGare("Nantes Est");
        tableGare.setVille("Nantes");
        tableGare.setNombreQuais(5);

        assertThat(tableGare.getIdGare()).isEqualTo(1234L);
        assertThat(tableGare.getNomGare()).isEqualTo("Nantes Est");
        assertThat(tableGare.getVille()).isEqualTo("Nantes");
        assertThat(tableGare.getNombreQuais()).isEqualTo(5);
    }
}
