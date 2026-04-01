package com.example.projettrain.repositorys;

import com.example.projettrain.entities.Course;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface CourseRepository extends ListCrudRepository<Course, Long> {
}
