package com.example.otus_project.domain;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class CustomUser extends User {

    private final int id;


    public CustomUser(String userName, String password, List<GrantedAuthority> authorityList, int id) {
        super(userName, password, authorityList);

        this.id = id;
    }
}
