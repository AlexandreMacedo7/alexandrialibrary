package com.alexandre.alexandrialibrary.service;

import com.alexandre.alexandrialibrary.model.dto.CreateUserDTO;
import com.alexandre.alexandrialibrary.repository.UserRepository;
import com.alexandre.alexandrialibrary.util.mapper.UserMapper;
import com.alexandre.alexandrialibrary.validation.uservalidation.UserValidator;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final List<UserValidator> validator;

    public UserService(UserRepository userRepository, UserMapper userMapper, List<UserValidator> validator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.validator = validator;
    }

    @Transactional
    public void create(CreateUserDTO userDTO){

        validator.forEach(v -> v.validate(userDTO));

        var user = userMapper.toEntity(userDTO);

        userRepository.save(user);
    }
}
