package com.alexandre.alexandrialibrary.repository;

import com.alexandre.alexandrialibrary.model.BookLending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLendingRepository extends JpaRepository<BookLending, Long> {
}
