package com.example.projettrain.controllers;

import com.example.projettrain.dto.CourseDTO;
import com.example.projettrain.services.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/courses", produces = "application/json")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO create(@Valid @RequestBody CourseDTO courseDTO) {
        return this.courseService.create(courseDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getAll() {
        return this.courseService.getAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDTO getById(@PathVariable @NotNull(message = "Course's ID is required") Long id) {
        return this.courseService.getById(id);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDTO updateHoraires(@PathVariable @NotNull(message = "Course's ID is required") Long id,
                                    @RequestBody CourseDTO courseDTO) {
        return this.courseService.updateHoraires(id, courseDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.GONE)
    public void remove(@RequestBody CourseDTO courseDTO) {
        this.courseService.remove(courseDTO);
    }
}

