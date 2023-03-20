package ru.otus.homework.services;

import java.util.List;

public interface GenericDomainCrud<K, T> {
    T save(T domain);

    void delete(T domain);

    List<T> findAll();

}