package com.alexandre.alexandrialibrary.service;

import com.alexandre.alexandrialibrary.model.Book;
import com.alexandre.alexandrialibrary.model.BookPublisher;
import com.alexandre.alexandrialibrary.model.dto.CreateBookDTO;
import com.alexandre.alexandrialibrary.repository.BookPublisherRepository;
import com.alexandre.alexandrialibrary.repository.BookRepository;
import com.alexandre.alexandrialibrary.util.mapper.BookMapper;
import com.alexandre.alexandrialibrary.validation.bookvalidation.BookValidator;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookPublisherRepository publisherRepository;
    private final List<BookValidator> bookValidators;

    public BookService(BookRepository bookRepository, BookMapper bookMapper, BookPublisherRepository publisherRepository, List<BookValidator> bookValidators) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.publisherRepository = publisherRepository;
        this.bookValidators = bookValidators;
    }

    @Transactional
    public void createBook(CreateBookDTO bookDTO) {

        bookValidators.forEach(v -> v.validate(bookDTO));

        var book = bookMapper.toEntity(bookDTO);

        var bookPublisher = createAndSavePublisher(bookDTO.publisherDTO().name());
        book.setPublisher(bookPublisher);
        bookRepository.save(book);
    }

    public void removeBook(Book book){
        book.setQuantity(book.getQuantity() - 1);
    }
    @Transactional
    private BookPublisher createAndSavePublisher(String namePublisher) {

        var publisher = checksTheExistenceOfAPublisher(namePublisher);

        if (publisher == null){
            publisher = createPublisher(namePublisher);
            return publisherRepository.save(publisher);
        }
        return publisher;
    }

    private BookPublisher checksTheExistenceOfAPublisher(String namePublisher) {
        return publisherRepository.findByName(namePublisher);
    }
    private BookPublisher createPublisher(String namePublisher) {
        return new BookPublisher(namePublisher);
    }
}
