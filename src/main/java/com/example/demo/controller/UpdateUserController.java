package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Optional;

@Service
@Transactional
public class UpdateUserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PublicRepository publicRepository;

    public User getUserByUsername(String id){   //function finds user by the id
        Optional<User> user = userRepository.findByUsername(id);
        return user.get();
    }

    public Public getPublicByUsername(String id) { // finds public object by the id
        Optional<Public> aPublic = publicRepository.findByUsername(id);
        {
            return aPublic.get();
        }
    }

    public void updateUser (String user_id, String password, String roles){
    userRepository.updateUser(user_id, password, roles); //call to userRepo class method
    }

    public void updatePublic (User public_userid, String first_name, String lastName,
                              Date dob, Integer contact_no, String residential_address){
        publicRepository.updatePublic(public_userid, first_name, lastName,
                dob, contact_no, residential_address); //call to PublicRepository class method
    }
}
