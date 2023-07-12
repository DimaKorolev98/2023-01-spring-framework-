package com.example.otus_project.servises;

import com.example.otus_project.domain.Producer;

import java.util.List;

public interface ProducersInterface extends GenericDomainCrud<Integer, Producer> {

    @Override
    Producer save(Producer producer);

    @Override
    void delete(Producer producer);

    @Override
    List<Producer> findAll();

    @Override
    void deleteAll();
}
