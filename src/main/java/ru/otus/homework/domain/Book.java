package ru.otus.homework.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "books")
public class Book {

    @Id
    private String id;

    private String title;

    @DBRef
    private Author author;
    @DBRef
    private Genre genre;

    @DBRef
    private List<Comment> comments;

    public Book(String title) {
        this.title = title;
    }




    public Book(String title, Author author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
    public Book(String id, String title, Author author, Genre genre) {
        this.id= id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }




    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", Название: '" + title + '\'' +
                ", Автор: " + author.getName() +
                ", Жанр: " + genre.getName() +
                ", Коментарии: " + (comments != null ? comments: "Нет Комментариев" )+
                '}';
    }
}