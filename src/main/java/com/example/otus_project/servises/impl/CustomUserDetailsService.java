package com.example.otus_project.servises.impl;

import com.example.otus_project.repositories.CustomerRepo;

import com.example.otus_project.domain.CustomUser;
import com.example.otus_project.domain.Customer;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerRepo customerRepository;

    public CustomUserDetailsService(CustomerRepo customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    @Transactional

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUserName(userName);
        return new CustomUser( customer.getUserName(), customer.getPassword(),
                AuthorityUtils.createAuthorityList(customer.getRole()),customer.getId());
    }
}