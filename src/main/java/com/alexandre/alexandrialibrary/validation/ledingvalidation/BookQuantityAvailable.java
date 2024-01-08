package com.alexandre.alexandrialibrary.validation.ledingvalidation;

import com.alexandre.alexandrialibrary.infra.ValidationException;
import com.alexandre.alexandrialibrary.model.Book;
import com.alexandre.alexandrialibrary.model.BookLending;
import org.springframework.stereotype.Component;

@Component
public class BookQuantityAvailable implements LendingValidator<BookLending> {

    @Override
    public void validate(BookLending bookLending) {
        validateQuantity(bookLending.getBook());
    }


    private void validateQuantity(Book book) {
        if (book.getQuantity() <= 0) {
            throw new ValidationException("Este livro não está disponível no estoque.");
        }
    }

}
