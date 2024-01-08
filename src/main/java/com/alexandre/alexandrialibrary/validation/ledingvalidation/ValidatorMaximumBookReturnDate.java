package com.alexandre.alexandrialibrary.validation.ledingvalidation;

import com.alexandre.alexandrialibrary.infra.ValidationException;
import com.alexandre.alexandrialibrary.model.BookLending;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class ValidatorMaximumBookReturnDate implements LendingValidator<BookLending> {
    @Override
    public void validate(BookLending bookLending) {
        checkMaximumBookReturnDate(bookLending.getDateOfWithdrawal(), bookLending.getReturnDate());
    }
    private void checkMaximumBookReturnDate(LocalDate dateOfWithdrawal,LocalDate returnDate){

        long daysDifference = ChronoUnit.DAYS.between(dateOfWithdrawal, returnDate);

        if (daysDifference > 30){
            throw new ValidationException("A data de devolução não pode ser superior a 30 dias!");
        }
    }
}
