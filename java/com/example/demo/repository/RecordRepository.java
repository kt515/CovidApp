package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecordRepository extends JpaRepository<Record, String>{
    @Query("SELECT r FROM Record r WHERE r.public_record.publicId.public_userid.user_id = ?1")
    List<Record> getAllRecord(String id);

    @Query("SELECT r FROM Record r JOIN Business b ON b.positive_case = 1 GROUP BY r.public_record.publicId.public_userid.user_id ORDER BY r.date_visited DESC")
    public List<Record> findInfoPublic();

    @Query("SELECT r FROM Record r JOIN Public p ON p.positive_case = 1 GROUP BY r.business_record.businessId.store_id.user_id ORDER BY r.date_visited DESC")
    public List<Record> findInfoBusiness();

    @Query("SELECT r FROM Record r WHERE r.business_record.businessId.store_id.user_id = ?1")
    List<Record> listAllAsBus(String id);

}