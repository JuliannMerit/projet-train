package com.example.projettrain.repositorys;

import com.example.projettrain.entities.Train;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface TrainRepository extends ListCrudRepository<Train, Long> {
}
