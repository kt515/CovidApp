package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.Alert;
import com.example.demo.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;

@Service
public class viewAlertController {

    @Autowired
    private AlertRepository alertRepo;

    public List<Alert> getNotification() {
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        UserDetails ud = (UserDetails) au.getPrincipal();

        return alertRepo.listAll(ud.getUsername().toString());

    }

}
