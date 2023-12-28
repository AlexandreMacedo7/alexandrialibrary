package com.alexandre.alexandrialibrary.repository;

import com.alexandre.alexandrialibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
