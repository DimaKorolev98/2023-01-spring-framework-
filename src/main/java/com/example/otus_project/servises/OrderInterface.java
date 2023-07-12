package com.example.otus_project.servises;

import com.example.otus_project.domain.Order;

import java.util.List;

public interface OrderInterface extends GenericDomainCrud<Integer, Order>{
    @Override
    Order save(Order order);

    @Override
    void delete(Order order);

    @Override
    List<Order> findAll();

    @Override
    void deleteAll();
}
