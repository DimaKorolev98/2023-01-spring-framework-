package com.example.otus_project.servises;

import com.example.otus_project.domain.Customer;

import java.util.List;

public interface CustomerInterface extends GenericDomainCrud<Integer, Customer>{

    @Override
    Customer save(Customer domain);

    @Override
    void delete(Customer domain);

    @Override
    void deleteAll();

    @Override
    List<Customer> findAll();
}
