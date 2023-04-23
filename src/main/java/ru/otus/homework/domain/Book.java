package ru.otus.homework.domain;

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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id")
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

    @Override
    public String toString() {
        return id +
                " Наименование: " + title +
                ". Автор: " + (author!=null ? author.getName() : "Нет Автора")
                +
                ". Жанр: " + (genre!=null ? genre.getName() : "Нет жанра")
                + ". Коментарии:" + (comments !=null ? comments.toString():"Нет комментариев")
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