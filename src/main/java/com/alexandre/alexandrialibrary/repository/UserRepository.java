package com.alexandre.alexandrialibrary.repository;

import com.alexandre.alexandrialibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
