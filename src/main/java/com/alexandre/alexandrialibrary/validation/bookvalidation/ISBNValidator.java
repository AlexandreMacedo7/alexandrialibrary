package com.alexandre.alexandrialibrary.validation.bookvalidation;

import com.alexandre.alexandrialibrary.model.dto.CreateBookDTO;
import com.alexandre.alexandrialibrary.repository.BookRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class ISBNValidator implements BookValidator<CreateBookDTO> {

    private final BookRepository bookRepository;

    public ISBNValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void validate(CreateBookDTO dto) {
        validateISBNExists(dto.ISBN());
    }

    private void validateISBNExists(String ISBN){
        if (bookRepository.existsByISBN(ISBN)){
            throw new DataIntegrityViolationException("O IBNS: " + ISBN + " já está em uso.");
        }
    }
}
