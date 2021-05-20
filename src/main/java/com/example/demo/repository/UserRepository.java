package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    @Query("SELECT u FROM User u WHERE u.id = ?1")
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE CONCAT(u.id, ' ', u.firstName, ' ', u.lastName, ' ', u.roles) LIKE %?1%")
    List<User> search(String keyword);
    
    List<User> findAll();
}
