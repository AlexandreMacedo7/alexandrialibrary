package com.alexandre.alexandrialibrary.service;

import com.alexandre.alexandrialibrary.model.Book;
import com.alexandre.alexandrialibrary.model.BookLending;
import com.alexandre.alexandrialibrary.model.User;
import com.alexandre.alexandrialibrary.model.dto.CreateLendingDTO;
import com.alexandre.alexandrialibrary.repository.BookLendingRepository;
import com.alexandre.alexandrialibrary.repository.BookRepository;
import com.alexandre.alexandrialibrary.repository.UserRepository;
import com.alexandre.alexandrialibrary.util.mapper.BookLendingMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BookLendingService {

    private final BookLendingRepository lendingRepository;
    private final BookLendingMapper lendingMapper;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public BookLendingService(BookLendingRepository lendingRepository, BookLendingMapper lendingMapper, UserRepository userRepository, BookRepository bookRepository) {
        this.lendingRepository = lendingRepository;
        this.lendingMapper = lendingMapper;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void create (CreateLendingDTO dto){

        var user = userSearch(dto.idUser());
        var book = bookSearch(dto.idBook());
        var bookLending = lendingMapper.toEntity(dto);

        bookLending.setUser(user);
        bookLending.setBook(book);

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
        book.addLoan(bookLending);
        bookRepository.save(book);
    }
}
