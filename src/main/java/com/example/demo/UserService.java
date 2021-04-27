package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getUser(){
        return List.of(
                new User(
                        "S9739367G",
                        "Steven Lim",
                        "Public"
                )
        );
    }
}
