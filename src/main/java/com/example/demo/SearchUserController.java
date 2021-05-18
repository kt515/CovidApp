package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SearchUserController {

        @Autowired
        private UserRepository repo;

        public List<User> listAll() {  // list all users
            return repo.findAll();
        }

        public User get(String id) {     // get a particular user
            return repo.findById(id).get();
        }

}




