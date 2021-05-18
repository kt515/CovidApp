package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    @Query("SELECT u FROM User u WHERE u.id = ?1")
    Optional<User> findByUsername(String username);
}
