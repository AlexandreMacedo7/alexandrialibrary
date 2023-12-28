package com.alexandre.alexandrialibrary.model.dto;

import com.alexandre.alexandrialibrary.util.enums.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateBookDTO(
        @NotBlank
        String title,
        @NotBlank
        String author,
        @NotBlank
        String ISBN,
        @NotNull
        Genre genre,
        @NotNull
        int numberOfPages,
        @NotNull
        CreateBookPublisherDTO publisherDTO,
        @NotNull
        LocalDate publicationDate,
        @NotNull
        int quantity
) {
}
