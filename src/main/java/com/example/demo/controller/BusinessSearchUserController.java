package com.example.demo.controller;

import com.example.demo.repository.BusinessSearchUserPubRepo;
import com.example.demo.repository.BusinessSearchUserRecRepo;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

import com.example.demo.entity.Public;
import com.example.demo.entity.Record;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;

@Service
@Transactional
public class BusinessSearchUserController {
    
    @Autowired
    private BusinessSearchUserRecRepo businessSearchUserRecRepo;

    @Autowired
    private BusinessSearchUserPubRepo businessSearchUserPubRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Record> listAllRec(Date date){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails)auth.getPrincipal();
        return businessSearchUserRecRepo.getUsers(userDetails.getUsername().toString(), date);
    }

    public List<Public> listAllPub(){
        System.out.println("am i played?");
        return businessSearchUserPubRepo.findAll();
    }

    public List<User> listAllUser(){
        return userRepo.findAll();
    }
}
