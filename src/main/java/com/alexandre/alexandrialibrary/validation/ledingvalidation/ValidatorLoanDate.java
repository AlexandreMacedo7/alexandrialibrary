package com.alexandre.alexandrialibrary.validation.ledingvalidation;

import com.alexandre.alexandrialibrary.infra.ValidationException;
import com.alexandre.alexandrialibrary.model.BookLending;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;
@Component
public class ValidatorLoanDate implements LendingValidator<BookLending> {
    @Override
    public void validate(BookLending bookLending) {
     checkLoanDate(bookLending.getDateOfWithdrawal());
    }

    private void checkLoanDate(LocalDate dateOfWithdrawal){
        if(!dateOfWithdrawal.equals(LocalDate.now())){
            throw new ValidationException("A data de empréstimo deve ser do dia de hoje! ");
        }
    }
}
