package com.alexandre.alexandrialibrary.validation.bookvalidation;

public interface BookValidator<T> {

    void validate(T dto);
}
