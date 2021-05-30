package com.example.demo.repository;
import java.sql.Date;
import java.util.List;

import com.example.demo.entity.Record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BusinessSearchUserRecRepo extends JpaRepository<Record,String> {
    @Query("SELECT r FROM Record r WHERE r.business_record.businessId.store_id.user_id = ?1 AND r.date_visited = ?2")
    List<Record> getUsers(String id, Date date);
}