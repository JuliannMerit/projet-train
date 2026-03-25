package com.example.projettrain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gares")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Gares {
    @Id
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
}