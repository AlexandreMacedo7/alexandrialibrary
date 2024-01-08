package com.alexandre.alexandrialibrary.validation.ledingvalidation;

import com.alexandre.alexandrialibrary.infra.ValidationException;
import com.alexandre.alexandrialibrary.model.BookLending;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class ValidatorBookReturnDate implements LendingValidator<BookLending> {
    @Override
    public void validate(BookLending bookLending) {
        checkBookReturnDate(bookLending.getDateOfWithdrawal(), bookLending.getReturnDate());
    }
    private void checkBookReturnDate(LocalDate dateOfWithdrawal,LocalDate returnDate){
        if (returnDate.isBefore(dateOfWithdrawal)){
            throw new ValidationException("A data de devolução não pode ser anterior a data de empréstimo!");
        }
    }
}
