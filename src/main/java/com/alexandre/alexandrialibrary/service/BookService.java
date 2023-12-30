package com.alexandre.alexandrialibrary.service;

import com.alexandre.alexandrialibrary.model.BookPublisher;
import com.alexandre.alexandrialibrary.model.dto.CreateBookDTO;
import com.alexandre.alexandrialibrary.repository.BookPublisherRepository;
import com.alexandre.alexandrialibrary.repository.BookRepository;
import com.alexandre.alexandrialibrary.util.mapper.BookMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    private final BookPublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, BookMapper bookMapper, BookPublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public void createBook(CreateBookDTO bookDTO) {

        var book = bookMapper.toEntity(bookDTO);

        var bookPublisher = createAndSavePublisher(bookDTO.publisherDTO().name());
        book.setPublisher(bookPublisher);
        bookRepository.save(book);
    }

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
