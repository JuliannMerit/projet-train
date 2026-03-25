package com.example.projettrain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "gare")
@Getter
@Setter
public class GareEntity {
    @Id
    @NotNull
    public Long idGare;
    @NotNull
    public String nomGare;
    @NotNull
    public String Ville;
    @NotNull
    public int nombreQuais;
}