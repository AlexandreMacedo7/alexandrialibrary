package com.alexandre.alexandrialibrary.repository;

import com.alexandre.alexandrialibrary.model.Book;
import com.alexandre.alexandrialibrary.model.BookLending;
import com.alexandre.alexandrialibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLendingRepository extends JpaRepository<BookLending, Long> {

    @Query("SELECT COUNT(bl) > 0 FROM BookLending bl " +
            "WHERE bl.user = :user " +
            "AND bl.book = :book " +
            "AND bl.returned = false")
    boolean existsActiveLoanForSameUserBook(@Param("user") User user, @Param("book") Book book);
}
