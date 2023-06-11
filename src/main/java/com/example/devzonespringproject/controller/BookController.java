package com.example.devzonespringproject.controller;

import com.example.devzonespringproject.model.dto.BookDto;
import com.example.devzonespringproject.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getBooks(@RequestParam(defaultValue = "0") Integer pageNo,
                                  @RequestParam(defaultValue = "5") Integer pageSize) {
        return bookService.getBooks(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
    }

    @PutMapping("/{id}")
    public void editBook(@PathVariable Long id,
                         @RequestBody BookDto bookDto) {
        bookService.editBook(id, bookDto);
    }
}
