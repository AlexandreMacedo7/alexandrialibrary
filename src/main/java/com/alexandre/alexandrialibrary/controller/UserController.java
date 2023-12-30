package com.alexandre.alexandrialibrary.controller;

import com.alexandre.alexandrialibrary.model.dto.CreateBookDTO;
import com.alexandre.alexandrialibrary.model.dto.CreateUserDTO;
import com.alexandre.alexandrialibrary.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserDTO dto) {
        userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
