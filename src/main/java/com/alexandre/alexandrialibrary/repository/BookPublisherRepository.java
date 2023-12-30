package com.alexandre.alexandrialibrary.repository;

import com.alexandre.alexandrialibrary.model.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPublisherRepository extends JpaRepository<BookPublisher, Long> {
    BookPublisher findByName(String name);
}
