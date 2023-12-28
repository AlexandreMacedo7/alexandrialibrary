package com.alexandre.alexandrialibrary.repository;

import com.alexandre.alexandrialibrary.model.BookLending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLendingRepository extends JpaRepository<BookLending, Long> {
}
