package ru.otus.homework.services;

import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface BookService {
   List<Book> findAll();
   void deleteById(String title);
   void addBook (String title, String authorName, String genre);
   Book findBookByTitle(String title);
   String toStringWithComments(Book book);
   List<Comment> getComments(String title);
}
