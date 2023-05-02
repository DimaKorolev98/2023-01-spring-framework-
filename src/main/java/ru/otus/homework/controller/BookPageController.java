package ru.otus.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.homework.domain.Book;
import ru.otus.homework.repositories.BookRepository;
import ru.otus.homework.services.AuthorService;
import ru.otus.homework.services.BookService;
import ru.otus.homework.services.GenreService;

@Controller
@RequiredArgsConstructor
public class BookPageController {

    private final BookRepository bookRepository;
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @GetMapping("/")
    public String listPage() {
        return "list";
    }

    @GetMapping("/book")
    public String bookPage(@RequestParam("id") long id, Model model) {
        model.addAttribute("id", id);
        return "book";
    }

    @GetMapping("/add")
    public String addPage() {
        return "add";
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
