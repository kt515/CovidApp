package com.example.demo.repository;

import com.example.demo.entity.Business;
import com.example.demo.entity.Public;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BusinessRepository extends JpaRepository<Business, User> {
    List <Business> findAll();

    @Query("SELECT b FROM Business b WHERE b.businessId.store_id.user_id = ?1")
    Optional<Business> findByUsername(String username);
}
