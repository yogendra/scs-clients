package com.example.bookstoreuiresttemplatehystrix.controller;

import com.example.bookstoreuiresttemplatehystrix.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/book")
    public String greeting(Model model) {
        model.addAttribute("recommendedbook", bookService.readingList());
        return "book";
    }
}
