package com.alexandre.alexandrialibrary.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserDTO(
        @NotBlank
        String name,
        @NotBlank
        String cpf,
        @NotBlank
        String phoneNumber,
        @NotBlank
        String email,
        @NotNull
        CreateAddressDTO addressDTO
) {
}
