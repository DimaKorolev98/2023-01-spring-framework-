package com.example.otus_project.repositories;

import com.example.otus_project.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {
    List<Order> findAllByCustomerId(int id);
}
