package com.example.otus_project.repositories;

import com.example.otus_project.domain.Producer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducerRepo extends CrudRepository<Producer, Integer> {
    List<Producer> findAll();
}
