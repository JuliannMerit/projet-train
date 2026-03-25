package com.example.projettrain.dto;

import com.example.projettrain.entities.Gare;
import com.example.projettrain.entities.Train;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class CourseDTO {
    @NotNull
    private Date heureDepart;
    @NotNull
    private Date heureArrivee;
    @NotNull
    private Gare gareOrigine;
    @NotNull
    private Gare gareTerminus;
    @NotNull
    private Train train;

}
