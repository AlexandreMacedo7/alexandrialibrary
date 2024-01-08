package com.alexandre.alexandrialibrary.validation.ledingvalidation;

import com.alexandre.alexandrialibrary.infra.ValidationException;
import com.alexandre.alexandrialibrary.model.Book;
import com.alexandre.alexandrialibrary.model.BookLending;
import com.alexandre.alexandrialibrary.model.User;
import com.alexandre.alexandrialibrary.repository.BookLendingRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidatorBookWithLoanInProgress implements LendingValidator<BookLending>{


    private final BookLendingRepository lendingRepository;

    public ValidatorBookWithLoanInProgress(BookLendingRepository lendingRepository) {
        this.lendingRepository = lendingRepository;
    }

    @Override
    public void validate(BookLending bookLending) {
        checksWhetherBookHasAlreadyBeenLoaned(bookLending.getUser(), bookLending.getBook());
    }
    private void checksWhetherBookHasAlreadyBeenLoaned(User user, Book book){
        if (lendingRepository.existsActiveLoanForSameUserBook(user, book)){
            throw new ValidationException("Usuario já emprestou esse livro");
        }
    }
}
