package ru.otus.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.homework.domain.Book;
import ru.otus.homework.repositories.BookRepository;
import ru.otus.homework.repositories.GenreRepository;
import ru.otus.homework.services.AuthorService;
import ru.otus.homework.services.BookService;
import ru.otus.homework.services.GenreService;


import java.util.List;
@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @GetMapping("/")
    public String listPage(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "list";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        model.addAttribute("genreList", genreService.findAll());
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("book", book);
        return "edit";
    }

    @PostMapping("/edit")
    public String editBook(Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }

    @PostMapping("/add/new")
    public String saveBook(Book book, String title, String authorName, String genreName) {
        bookService.addBook(book, title, authorName, genreName);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("id") long id, Model model){
        Book book = bookRepository.findById(id).orElseThrow(NotFoundException::new);

        model.addAttribute("book", book);
        return "delete_book";
    }

    @PostMapping("/delete")
    public String deleteBook(Book book){
        bookService.delete(book);
        return "redirect:/";
    }
}
