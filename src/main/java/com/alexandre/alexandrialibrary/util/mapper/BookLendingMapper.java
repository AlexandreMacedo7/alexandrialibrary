package com.alexandre.alexandrialibrary.util.mapper;

import com.alexandre.alexandrialibrary.model.BookLending;
import com.alexandre.alexandrialibrary.model.dto.CreateLendingDTO;
import org.springframework.stereotype.Component;

@Component
public class BookLendingMapper {

    public BookLending toEntity(CreateLendingDTO lendingDTO){

        BookLending bookLending = new BookLending();
        bookLending.setDateOfWithdrawal(lendingDTO.dateOfWithdrawal());
        bookLending.setReturnDate(lendingDTO.returnDate());

        return bookLending;
    }
}
