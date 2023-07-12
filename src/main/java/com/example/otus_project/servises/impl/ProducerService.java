package com.example.otus_project.servises.impl;

import com.example.otus_project.repositories.ProducerRepo;
import com.example.otus_project.servises.ProducersInterface;
import com.example.otus_project.domain.Producer;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProducerService")
public class ProducerService implements ProducersInterface {

    private final ProducerRepo producerRepo;


    public ProducerService(ProducerRepo producerRepo) {
        this.producerRepo = producerRepo;
    }

    @Override
    public Producer save(Producer producer) {
        return producerRepo.save(producer);
    }

    @Override
    public void delete(Producer producer) {
        producerRepo.delete(producer);
    }

    @Override
    public List<Producer> findAll() {
        return Lists.newArrayList(producerRepo.findAll());
    }

    @Override
    public void deleteAll() {
        producerRepo.deleteAll();
    }
}
