package com.example.demo.controller;

import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

import com.example.demo.entity.VaccineCert;
import com.example.demo.repository.VaccineCertRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HealthStaffUpdateCertController {

    @Autowired
    private VaccineCertRepository vaccineCertRepo;

    public VaccineCert getUser(String id){
        return vaccineCertRepo.getPub(id);
    }

    public void updateCert(Date date, String time, String vaccine_location, String cert_id){
        vaccineCertRepo.updateCert(date, time, vaccine_location, cert_id);
    }
}
