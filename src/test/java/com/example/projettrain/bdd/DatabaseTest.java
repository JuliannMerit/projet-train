package com.example.projettrain.bdd;

import com.example.projettrain.entities.Gares;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DatabaseTest {

    @Test
    public void creeDesInstancesDansLaTableGares(){
        Gares tableGares = new Gares(1234L, "Nantes Est", "Nantes", 5);
        tableGares.setIdGare(1234L);
        tableGares.setNomGare("Nantes Est");
        tableGares.setVille("Nantes");
        tableGares.setNombreQuais(5);
        assertThat(tableGares.getNomGare()).isEqualTo("Nantes Est");
    }
}
