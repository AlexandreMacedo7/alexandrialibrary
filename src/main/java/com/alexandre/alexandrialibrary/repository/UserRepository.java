package com.alexandre.alexandrialibrary.repository;

import com.alexandre.alexandrialibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
