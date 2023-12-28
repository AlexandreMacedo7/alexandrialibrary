package com.alexandre.alexandrialibrary.repository;

import com.alexandre.alexandrialibrary.model.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, Long> {
}
