package com.alexandre.alexandrialibrary.model.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateBookPublisherDTO(
        @NotBlank
        String name) {
}
