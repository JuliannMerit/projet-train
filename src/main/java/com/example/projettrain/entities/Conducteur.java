package com.example.projettrain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "conducteurs")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Conducteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "numero_tel", nullable = false)
    private String numeroTel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Habilitation habilitation;

    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Train> trains;
}

