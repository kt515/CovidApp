package com.example.demo.repository;

import com.example.demo.entity.HealthOrg;
import com.example.demo.entity.Public;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HealthOrgRepository extends JpaRepository<HealthOrg,String> {

    List<HealthOrg> findAll();

    @Query("SELECT ho FROM HealthOrg ho WHERE ho.healthOrgId.org_id.user_id = ?1")
    Optional<HealthOrg> findByUsername(String username);
}
