package com.example.otus_project.repositories;

import com.example.otus_project.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

    Customer findByUserName(String userName);

}
