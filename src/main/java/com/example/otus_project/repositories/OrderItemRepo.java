package com.example.otus_project.repositories;

import com.example.otus_project.domain.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepo extends CrudRepository<OrderItem, Integer> {
}
