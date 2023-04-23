package ru.otus.homework.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "books")
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    @JsonManagedReference
    private Author author;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id")
    @JsonManagedReference
    private Genre genre;

    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;
    public Book(String title) {
        this.title = title;
    }

    public Book(long id, String title){
        this.id = id;
        this.title = title;
    }

    public Book(String title, Author author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }




    @Override
    public String toString() {
        return id +
                " Наименование: " + title +
                ". Автор: " + author.getName()
                +
                ". Жанр: " + genre.getName()
                + ". Коментарии:" + comments.toString()
                + "\n";
    }

    public String toStringWithCommentsCount() {
        return id +
                " Наименование: " + title +
                ". Автор: " + author.getName() +
                ". Жанр: " + genre.getName()
                + "\n";
    }

}