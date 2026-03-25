package com.example.projettrain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "gare")
@Getter
@Setter
public class Gare {
    @Id
    @NotNull
    @GeneratedValue
    public Long idGare;
    @NotNull
    public String nomGare;
    @NotNull
    public String ville;
    @NotNull
    public int nombreQuais;

    @OneToMany(mappedBy = "gare")
    private List<CourseGare> courses = new ArrayList<>();

    public Gares(String nomGare, String ville, int nombreQuais){
        this.nomGare = nomGare;
        this.ville = ville;
        this.nombreQuais = nombreQuais;
    }

    @Override
    public String toString() {
        return nomGare + " - " + ville + " (" + nombreQuais + " quais)";
    }

}