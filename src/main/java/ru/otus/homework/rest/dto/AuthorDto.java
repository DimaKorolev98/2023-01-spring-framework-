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
    private String id;
    private String name;



    public static AuthorDto toDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }

    public static Author toObject(AuthorDto authorDto){
        return new Author(authorDto.getId(), authorDto.getName());
    }
}
