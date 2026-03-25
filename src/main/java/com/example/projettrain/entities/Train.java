package com.example.projettrain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trains")
@Getter
@Setter
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeMateriel type;

    @Column(nullable = false)
    private int nombrePlace;

    @ManyToOne
    @JoinColumn(name = "conducteur_id", nullable = false)
    private Conducteur conducteur;

    // Constructeurs
    public Train() {
    }

    public Train(TypeMateriel type, int nombrePlace, Conducteur conducteur) {
        this.type = type;
        this.nombrePlace = nombrePlace;
        this.conducteur = conducteur;
    }


}
