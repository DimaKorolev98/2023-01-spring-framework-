package com.example.otus_project.repositories;

import com.example.otus_project.domain.Engine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineRepo extends CrudRepository<Engine, Integer> {
    List<Engine> findAll();
}
