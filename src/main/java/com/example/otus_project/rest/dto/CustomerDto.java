package com.example.otus_project.rest.dto;


import com.example.otus_project.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {
private int id;
private String userName;
private String email;


    public static CustomerDto toDto(Customer customer){
        return new CustomerDto(customer.getId(), customer.getUserName(), customer.getEmail());
    }

    public static Customer toObject(CustomerDto customerDto){

        return new Customer(customerDto.getId(),customerDto.getUserName(), customerDto.getEmail());

    }

}
