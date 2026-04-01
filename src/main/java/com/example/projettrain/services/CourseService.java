package com.example.projettrain.services;

import com.example.projettrain.dto.CourseDTO;
import com.example.projettrain.entities.Course;
import com.example.projettrain.repositorys.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseDTO create (CourseDTO courseDTO) {
        final var courseEntityBuilder = Course.builder()
                .heureDepart(courseDTO.getHeureDepart())
                .heureArrivee(courseDTO.getHeureArrivee())
                .gareOrigine(courseDTO.getGareOrigine())
                .gareTerminus(courseDTO.getGareTerminus())
                .train(courseDTO.getTrain());

        final var createdCourseEntity = this.courseRepository.save(courseEntityBuilder.build());
        return this.entityToDto(createdCourseEntity);
    }

    private CourseDTO entityToDto(Course courseEntity) {
        return CourseDTO.builder()
                .id(courseEntity.getId())
                .heureDepart(courseEntity.getHeureDepart())
                .heureArrivee(courseEntity.getHeureArrivee())
                .gareOrigine(courseEntity.getGareOrigine())
                .gareTerminus(courseEntity.getGareTerminus())
                .train(courseEntity.getTrain())
                .build();
    }

    public List<CourseDTO> getAll() {
        return this.courseRepository.findAll().stream().map(this::entityToDto).toList();
    }

    public CourseDTO getById(Long id) {
        Course courseEntity = this.courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        return this.entityToDto(courseEntity);
    }

    public void remove(CourseDTO courseDTO){
        final var courseEntity = this.courseRepository.findById(courseDTO.getId()).orElseThrow(() -> new RuntimeException("Course not found"));
        this.courseRepository.delete(courseEntity);
    }

    public CourseDTO updateHoraires(Long id, CourseDTO courseDTO) {
        final var courseEntity = this.courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        courseEntity.setHeureDepart(courseDTO.getHeureDepart());
        courseEntity.setHeureArrivee(courseDTO.getHeureArrivee());

        final var updatedCourseEntity = this.courseRepository.save(courseEntity);
        return this.entityToDto(updatedCourseEntity);
    }
}