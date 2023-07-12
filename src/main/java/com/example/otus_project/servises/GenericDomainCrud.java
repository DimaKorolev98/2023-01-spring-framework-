package com.example.otus_project.servises;

import java.util.List;

public interface GenericDomainCrud<K, T> {
    T save(T domain);

    void delete(T domain);
    void deleteAll();

    List<T> findAll();

}