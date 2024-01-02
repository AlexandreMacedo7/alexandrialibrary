package com.alexandre.alexandrialibrary.validation.ledingvalidation;

import com.alexandre.alexandrialibrary.model.dto.CreateLendingDTO;

public interface LendingValidator<T>{

    void validate(T t);
}
