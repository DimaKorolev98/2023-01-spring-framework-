package ru.otus.homework.changeLog;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;

import ru.otus.homework.domain.Book;
import ru.otus.homework.repositories.AuthorRepository;
import ru.otus.homework.repositories.BookRepository;
import ru.otus.homework.repositories.GenreRepository;
import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Genre;

@ChangeLog
public class DatabaseChangelog {
    private  Author author1;
    private  Author author2;
    private  Author author3;
    private  Author author4;
    private Genre genre1;
    private Genre genre2;
    private Genre genre3;
    private Genre genre4;


    @ChangeSet(order = "001", id = "dropDb", author = "simba", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "change1", author = "simba")
    public void insertAuthors(AuthorRepository authorRepository) {
        author1 = authorRepository.save(new Author("Энрих Мария Ремарк"));
        author2 = authorRepository.save(new Author("Джон Р. Р. Толкин"));
        author3 = authorRepository.save(new Author("Александр Сергеевич Пушкин"));
        author4 = authorRepository.save(new Author("Роберт Мартин"));
    }

    @ChangeSet(order = "003", id = "change2", author = "simba")
    public void insertGenres(GenreRepository genreRepository) {
        genre1 = genreRepository.save(new Genre("Роман"));
        genre2 = genreRepository.save(new Genre("Фантастика"));
        genre3 = genreRepository.save(new Genre("Поэма"));
        genre4 = genreRepository.save(new Genre("Компьютерные науки"));
    }

    @ChangeSet(order = "004", id = "change3", author = "simba")
    public void insertBooks(BookRepository bookRepository) {
        bookRepository.save(new Book("Три товарища", author1, genre1));
        bookRepository.save(new Book("Властелин колец",author2, genre2));
        bookRepository.save(new Book("Руслан и Людмила", author3, genre3));
        bookRepository.save(new Book("Чистый код", author4, genre4));
    }


}