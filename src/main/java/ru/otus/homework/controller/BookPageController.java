package ru.otus.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BookPageController {

    @GetMapping("/")
    public String listPage() {
        return "list";
    }



    @GetMapping("/add")
    public String addPage() {
        return "add";
    }


}
