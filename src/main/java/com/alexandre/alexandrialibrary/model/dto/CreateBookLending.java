package com.alexandre.alexandrialibrary.model.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateBookLending(
        @NotNull
        Long idUser,
        @NotNull
        Long idBook,
        @NotNull
        LocalDate dateOfWithdrawal,
        @NotNull
        LocalDate returnDate
) {
}
