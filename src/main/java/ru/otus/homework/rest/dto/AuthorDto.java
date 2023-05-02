package ru.otus.homework.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private long id;
    private String name;



    public static AuthorDto toDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }

}
