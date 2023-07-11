package ru.otus.homework.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name ="authors")
@AllArgsConstructor
@RequiredArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",unique = true)
    private String name;

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Book> books;

    public Author(String name){
        this.name = name;
    }

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + (name!= null? name : "Нет Имени") + ". Количество книг: " + (books != null ? books.size() : "Нет книг") +"\n";
    }

}