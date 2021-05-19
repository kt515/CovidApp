package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SearchUserController {

        @Autowired
        private UserRepository repo;

        public List<User> listAll(String keyword) {  // list all users
            if (keyword != null) {
                return repo.search(keyword);
            }
            return repo.findAll();
        }
}




