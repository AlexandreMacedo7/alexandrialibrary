package com.alexandre.alexandrialibrary.util.mapper;

import com.alexandre.alexandrialibrary.model.Book;
import com.alexandre.alexandrialibrary.model.dto.CreateBookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(CreateBookDTO bookDTO) {
        Book book = new Book();

        book.setTitle(bookDTO.title());
        book.setAuthor(bookDTO.author());
        book.setISBN(bookDTO.ISBN());
        book.setGenre(bookDTO.genre());
        book.setNumberOfPages(bookDTO.numberOfPages());
        book.setPublicationDate(bookDTO.publicationDate());
        book.setQuantity(bookDTO.quantity());

        return book;
    }
}
