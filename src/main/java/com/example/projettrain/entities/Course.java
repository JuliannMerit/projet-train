package com.example.projettrain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "heure_depart", nullable = false)
    private LocalDateTime heureDepart;
    
    @NotNull
    @Column(name = "heure_arrivee", nullable = false)
    private LocalDateTime heureArrivee;
    
    @ManyToOne
    @JoinColumn(name = "gare_origine_id")
    private Gares gareOrigine;
    
    @ManyToOne
    @JoinColumn(name = "gare_terminus_id")
    private Gares gareTerminus;

    /**
     * Parcours complet de la course via table intermédiaire (CourseGare).
     * Trié par ordre croissant.
     */
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("ordre ASC")
    private List<CourseGare> parcours = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

}
