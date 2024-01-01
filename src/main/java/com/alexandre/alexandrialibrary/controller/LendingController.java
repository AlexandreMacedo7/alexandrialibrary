package com.alexandre.alexandrialibrary.controller;

import com.alexandre.alexandrialibrary.model.dto.CreateLendingDTO;
import com.alexandre.alexandrialibrary.service.BookLendingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lending/")
public class LendingController {


    private final BookLendingService lendingService;

    public LendingController(BookLendingService lendingService) {
        this.lendingService = lendingService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> createLending(@RequestBody @Valid CreateLendingDTO dto) {
        lendingService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
