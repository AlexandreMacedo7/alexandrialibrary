package com.alexandre.alexandrialibrary.controller;

import com.alexandre.alexandrialibrary.model.dto.CreateBookDTO;
import com.alexandre.alexandrialibrary.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody @Valid CreateBookDTO dto) {
        bookService.createBook(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
