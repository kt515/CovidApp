package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import com.example.demo.entity.VaccineCert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VaccineCertRepository extends JpaRepository<VaccineCert, String> {

    @Query("SELECT vc FROM VaccineCert vc WHERE vc.public_cert.publicId.public_userid.user_id = ?1")
    List<VaccineCert> listAll(String ua); // lists the vaccine cert belonging to logged in user parameter passed in controller

    @Query("SELECT v FROM VaccineCert v WHERE v.public_cert.publicId.public_userid.user_id = ?1")
    VaccineCert getPub(String id);

    @Modifying
    @Query("UPDATE VaccineCert vc SET vc.date = ?1, vc.time = ?2, vc.vaccine_location = ?3 WHERE vc.cert_id = ?4")
    void updateCert(Date date, String time, String vaccine_location, String cert_id);
}
