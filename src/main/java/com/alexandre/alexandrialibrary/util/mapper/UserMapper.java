package com.alexandre.alexandrialibrary.util.mapper;

import com.alexandre.alexandrialibrary.model.User;
import com.alexandre.alexandrialibrary.model.dto.CreateUserDTO;
import com.alexandre.alexandrialibrary.util.Address;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(CreateUserDTO userDTO){
        User user = new User();

        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setCpf(userDTO.cpf());
        user.setPhoneNumber(userDTO.phoneNumber());

        Address address = new Address();
        address.setStreet(userDTO.addressDTO().street());
        address.setNeighborhood(userDTO.addressDTO().neighborhood());
        address.setZipCode(userDTO.addressDTO().zipCode());

        user.setAddress(address);

        return user;
    }
}
