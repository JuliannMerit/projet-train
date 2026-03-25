package com.example.projettrain.dto;

import com.example.projettrain.entities.Habilitation;
import com.example.projettrain.entities.Train;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConducteurDTO {
    @NotNull
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String numeroTel;
    @NotNull
    private Habilitation habilitation;
    @NotNull
    private List<Train> trains;
}