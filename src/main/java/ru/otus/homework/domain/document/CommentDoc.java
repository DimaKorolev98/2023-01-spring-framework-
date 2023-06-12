package ru.otus.homework.domain.document;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@RequiredArgsConstructor
@Document(collection = "comments")
public class CommentDoc {

    @Id
    private String id;

    private String text;

    public CommentDoc(String text, String bookId) {
        this.text = text;
    }

    public CommentDoc(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "[" + id + "]"+ " " +text + ".";
    }
}