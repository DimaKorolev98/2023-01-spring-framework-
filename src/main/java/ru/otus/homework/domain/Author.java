package ru.otus.homework.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "authors")
public class Author {

   @Id
    private String id;
    private String name;
    private List<String> books;


    public Author(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Author{" +
                "id:'" + id + '\'' +
                ", Имя:'" + name + '\'' +
                '}';
    }
}
