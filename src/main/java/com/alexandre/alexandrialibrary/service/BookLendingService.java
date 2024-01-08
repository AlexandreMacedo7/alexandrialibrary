package com.alexandre.alexandrialibrary.service;

import com.alexandre.alexandrialibrary.model.Book;
import com.alexandre.alexandrialibrary.model.BookLending;
import com.alexandre.alexandrialibrary.model.User;
import com.alexandre.alexandrialibrary.model.dto.CreateLendingDTO;
import com.alexandre.alexandrialibrary.repository.BookLendingRepository;
import com.alexandre.alexandrialibrary.repository.BookRepository;
import com.alexandre.alexandrialibrary.repository.UserRepository;
import com.alexandre.alexandrialibrary.util.mapper.BookLendingMapper;
import com.alexandre.alexandrialibrary.validation.ledingvalidation.LendingValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLendingService {

    private final BookLendingRepository lendingRepository;
    private final BookLendingMapper lendingMapper;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BookService bookService;
    private final List<LendingValidator> validators;

    public BookLendingService(BookLendingRepository lendingRepository, BookLendingMapper lendingMapper, UserRepository userRepository, BookRepository bookRepository, BookService bookService, List<LendingValidator> validators) {
        this.lendingRepository = lendingRepository;
        this.lendingMapper = lendingMapper;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.bookService = bookService;
        this.validators = validators;
    }

    @Transactional
    public void create (CreateLendingDTO dto){

        var user = userSearch(dto.idUser());
        var book = bookSearch(dto.idBook());
        var bookLending = lendingMapper.toEntity(dto);

        bookLending.setUser(user);
        bookLending.setBook(book);

        validators.forEach(v -> v.validate(bookLending));

        lendingRepository.save(bookLending);

        addBookLoanToUser(user, bookLending);
        addLoanToBook(book, bookLending);
    }

    private User userSearch(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado!"));
    }
    private Book bookSearch(Long bookId){
        return bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado!"));
    }
    private void addBookLoanToUser(User user, BookLending bookLending){
        user.addLoan(bookLending);
        userRepository.save(user);
    }
    private void addLoanToBook(Book book, BookLending bookLending){
        bookService.removeBook(book);
        book.addLoan(bookLending);
        bookRepository.save(book);
    }
}
