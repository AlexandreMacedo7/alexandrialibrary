package com.alexandre.alexandrialibrary.validation.uservalidation;

import com.alexandre.alexandrialibrary.model.dto.CreateUserDTO;
import com.alexandre.alexandrialibrary.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class EmailValidator implements UserValidator<CreateUserDTO>{

    private final UserRepository userRepository;

    public EmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(CreateUserDTO dto) {
        validateEmailExists(dto.email());
    }

    private void validateEmailExists(String email){
        if(userRepository.existsByEmail(email)){
            throw new DataIntegrityViolationException("O email: " + email + " já está em uso");
        }
    }
}
