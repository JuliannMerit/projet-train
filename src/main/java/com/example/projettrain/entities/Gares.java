package com.example.projettrain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "gares")
@Getter
@Setter
public class Gares {
    @Id
    @NotNull
    public Long idGare;
    @NotNull
    public String nomGare;
    @NotNull
    public String ville;
    @NotNull
    public int nombreQuais;

    /**
     * Constructeur sans argument requis par JPA.
     */
    public Gares() {
    }

    public Gares(Long idGare, String nomGare, String ville, int nombreQuais) {
        this.idGare = idGare;
        this.nomGare = nomGare;
        this.ville = ville;
        this.nombreQuais = nombreQuais;
    }

    @Override
    public String toString() {
        return nomGare + " - " + ville + " (" + nombreQuais + " quais)";
    }

}