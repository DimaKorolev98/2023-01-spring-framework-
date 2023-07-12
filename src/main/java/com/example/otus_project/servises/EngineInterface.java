package com.example.otus_project.servises;

import com.example.otus_project.domain.Engine;

import java.util.List;

public interface EngineInterface extends GenericDomainCrud<Integer, Engine> {
    @Override
    Engine save(Engine engine);

    @Override
    void delete(Engine engine);

    @Override
    List<Engine> findAll();

    @Override
    void deleteAll();
}
