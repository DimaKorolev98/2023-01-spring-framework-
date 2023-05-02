package ru.otus.homework.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.otus.homework.domain.Genre;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class GenreDto {
    private long id;
    private String name;



    public static GenreDto toDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }

}
