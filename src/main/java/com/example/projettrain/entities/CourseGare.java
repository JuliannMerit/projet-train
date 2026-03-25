package com.example.projettrain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Table intermédiaire entre Course et Gares.
 *
 * Avantages vs @ManyToMany:
 * - possibilité d'ajouter des attributs (ici: ordre)
 * - clé composite explicite
 */
@Entity
@Table(
        name = "course_gare",
        uniqueConstraints = {
                // une course ne peut pas avoir 2 fois la même gare dans son parcours
                @UniqueConstraint(name = "uk_course_gare", columnNames = {"course_id", "gare_id"}),
                // une course ne peut pas avoir 2 étapes avec le même ordre
                @UniqueConstraint(name = "uk_course_ordre", columnNames = {"course_id", "ordre"})
        }
)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseGare {

    @EmbeddedId
    private CourseGareId id = new CourseGareId();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("courseId")
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("gareId")
    @JoinColumn(name = "gare_id", nullable = false)
    private Gare gare;

    /**
     * Position de la gare dans le parcours (1..n).
     */
    @Column(name = "ordre", nullable = false)
    private int ordre;
}


