package com.example.demo.controller;

import java.util.List;

import com.example.demo.repository.VaccineCertRepository;
import com.example.demo.repository.VaccineCertRepository;
import com.example.demo.entity.VaccineCert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

@Service
public class VaccineCertController {

    @Autowired
    private VaccineCertRepository vaccineRepo;

    public List<VaccineCert> getNotification() {
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        String id = au.getName();
        return vaccineRepo.listAll(id);  // list all vaccine certs under the logged in user

    }

}

