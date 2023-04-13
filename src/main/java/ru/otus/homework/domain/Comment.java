package ru.otus.homework.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@RequiredArgsConstructor
@Document(collection = "comments")
public class Comment {

    @Id
    private String id;

    private String text;

    public Comment(String text, String bookId) {
        this.text = text;
    }

    public Comment(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "[" + id + "]"+ " " +text + ".";
    }
}