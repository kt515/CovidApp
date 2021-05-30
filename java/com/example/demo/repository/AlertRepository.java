package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Alert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AlertRepository extends JpaRepository<Alert, String> {

    @Query("SELECT al FROM Alert al WHERE al.user_alert.user_id = ?1")
    List<Alert> listAll(String ua);

    @Modifying
    @Query(value = "INSERT INTO alert (alert_id, message, users_id) values (:alert_id, :message, :users_id)", nativeQuery = true)
    @Transactional
    void addInfo(@Param("alert_id") String alert_id, @Param("message") String message,
            @Param("users_id") String users_id);

}
