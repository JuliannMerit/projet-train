package com.example.projettrain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clé composite de CourseGare.
 */
@Embeddable
@Getter
@Setter
public class CourseGareId implements Serializable {

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "gare_id")
    private Long gareId;

    public CourseGareId() {
    }

    public CourseGareId(Long courseId, Long gareId) {
        this.courseId = courseId;
        this.gareId = gareId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseGareId that = (CourseGareId) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(gareId, that.gareId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, gareId);
    }
}

