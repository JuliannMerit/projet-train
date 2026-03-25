package com.example.projettrain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "conducteurs")
@Getter
@Setter
public class Conducteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cp")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String numeroTel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Habilitation habilitation;

    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Train> trains;

    // Constructeurs
    public Conducteur() {
    }

    public Conducteur(String email, String numeroTel, Habilitation habilitation) {
        this.email = email;
        this.numeroTel = numeroTel;
        this.habilitation = habilitation;
    }

    /**
     * Alias métier pour l'identifiant (colonne "cp").
     * Les tests existants attendent getCp()/setCp().
     */
    public Long getCp() {
        return this.id;
    }

    public void setCp(Long cp) {
        this.id = cp;
    }
}
