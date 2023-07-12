package com.example.otus_project.servises.impl;


import com.example.otus_project.repositories.EngineRepo;
import com.example.otus_project.servises.EngineInterface;

import com.example.otus_project.domain.Engine;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("EngineService")

public class EngineService implements EngineInterface {
    private static final Logger LOGGER = LoggerFactory.getLogger(EngineService.class);
    private final EngineRepo engineRepo;

    @Autowired
    public EngineService(EngineRepo engineRepo) {
        this.engineRepo = engineRepo;
    }

    @Override
    public Engine save(Engine engine) {
        return engineRepo.save(engine);
    }

    @Override
    public void delete(Engine engine) {
        engineRepo.delete(engine);
    }

    @Override
    public List<Engine> findAll() {
        return
        Lists.newArrayList(engineRepo.findAll());
    }

    @Override
    public void deleteAll() {
        engineRepo.deleteAll();
    }
}
