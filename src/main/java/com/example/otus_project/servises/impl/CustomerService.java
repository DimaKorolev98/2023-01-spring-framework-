package com.example.otus_project.servises.impl;

import com.example.otus_project.repositories.CustomerRepo;
import com.example.otus_project.servises.CustomerInterface;
import com.example.otus_project.domain.Customer;

import java.util.List;

public class CustomerService implements CustomerInterface {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer save(Customer domain) {
        return null;
    }

    @Override
    public void delete(Customer domain) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

}
