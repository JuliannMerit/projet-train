package com.example.projettrain.dto;

import com.example.projettrain.entities.Gare;
import com.example.projettrain.entities.Train;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDTO {
    @NotNull
    private Long id;
    @NotNull
    private LocalDateTime heureDepart;
    @NotNull
    private LocalDateTime heureArrivee;
    @NotNull
    private Gare gareOrigine;
    @NotNull
    private Gare gareTerminus;
    @NotNull
    private Train train;
}
