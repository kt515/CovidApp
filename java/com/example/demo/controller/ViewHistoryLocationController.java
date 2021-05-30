package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Record;
import com.example.demo.repository.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;


@Service
@Transactional
public class ViewHistoryLocationController {
    
    @Autowired
    private RecordRepository repo;
    
    public List<Record> listAll(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String id = auth.getName();

        return repo.getAllRecord(id);
    }

}
