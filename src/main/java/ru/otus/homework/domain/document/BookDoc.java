package ru.otus.homework.domain.document;

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
public class BookDoc {

    @Id
    private String id;

    private String title;

    @DBRef(lazy = true)
    private AuthorDoc author;

    @DBRef(lazy = true)
    private GenreDoc genre;

    @DBRef(lazy = true)
    private List<CommentDoc> comments;

    public BookDoc(String title) {
        this.title = title;
    }




    public BookDoc(String title, AuthorDoc author, GenreDoc genre) {
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
