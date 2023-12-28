package com.alexandre.alexandrialibrary.model.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateAddressDTO(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        String zipCode
) {
}
