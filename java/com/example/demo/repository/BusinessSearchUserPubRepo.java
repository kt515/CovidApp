package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Public;
import com.example.demo.entity.PublicId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusinessSearchUserPubRepo extends JpaRepository<Public,PublicId>{
    List<Public> findAll();
}
