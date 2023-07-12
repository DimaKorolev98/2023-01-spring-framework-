package com.example.otus_project.servises;

import com.example.otus_project.domain.OrderItem;

import java.util.List;

public interface OrderItemInterface extends GenericDomainCrud<Integer, OrderItem>{
    @Override
    OrderItem save(OrderItem orderItem);

    @Override
    void delete(OrderItem orderItem);

    @Override
    void deleteAll();

    @Override
    List<OrderItem> findAll();
}
