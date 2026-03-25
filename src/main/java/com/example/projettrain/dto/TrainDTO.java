package com.example.projettrain.dto;

import com.example.projettrain.entities.Conducteur;
import com.example.projettrain.entities.TypeMateriel;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainDTO {
    @NotNull
    private Long id;
    @NotNull
    private TypeMateriel type;
    @NotNull
    private int nombrePlaces;
    private Conducteur conducteur;
}
