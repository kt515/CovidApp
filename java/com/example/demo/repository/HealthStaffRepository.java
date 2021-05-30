package com.example.demo.repository;

import com.example.demo.entity.HealthStaff;
import com.example.demo.entity.Public;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HealthStaffRepository extends JpaRepository<HealthStaff,String> {

    List<HealthStaff> findAll();

    @Query("SELECT hs FROM HealthStaff hs WHERE hs.healthStaffId.staff_id.user_id = ?1")
    Optional<HealthStaff> findByUsername(String username);
}
