package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.PublicRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Transactional
@Service
public class CreateUserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PublicRepository publicRepository;

    public void createUser(String user_id, String password, String roles) {
        userRepository.createUser(user_id, password, roles);
    }

    public void createPublic(User public_userid, String first_name, String lastName, Date dob, Integer contact_no,
                             String residential_address, boolean positive_case, boolean vaccinated){
        publicRepository.createPublic(public_userid,first_name,lastName,dob,contact_no,
                residential_address,positive_case,vaccinated);
    }
}

