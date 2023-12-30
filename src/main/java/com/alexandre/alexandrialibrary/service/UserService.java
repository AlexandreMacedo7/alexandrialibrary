package com.alexandre.alexandrialibrary.service;

import com.alexandre.alexandrialibrary.model.dto.CreateUserDTO;
import com.alexandre.alexandrialibrary.repository.UserRepository;
import com.alexandre.alexandrialibrary.util.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public void create(CreateUserDTO userDTO){


        var user = userMapper.toEntity(userDTO);
        userRepository.save(user);
    }
}
