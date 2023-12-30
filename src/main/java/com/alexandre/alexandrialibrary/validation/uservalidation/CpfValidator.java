package com.alexandre.alexandrialibrary.validation.uservalidation;

import com.alexandre.alexandrialibrary.model.dto.CreateUserDTO;
import com.alexandre.alexandrialibrary.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class CpfValidator implements UserValidator<CreateUserDTO>{

    private final UserRepository userRepository;

    public CpfValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(CreateUserDTO dto) {
        validateCpfExists(dto.cpf());
    }

    private void validateCpfExists(String cpf){
        if (userRepository.existsByCpf(cpf)){
            throw new DataIntegrityViolationException("O número de cpf já está em uso");
        }
    }
}
