package com.example.demo.boundary;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageUI {

    @Autowired
    private UserRepository userRepo; // create object userRepo

    @GetMapping("") // map to home page url
    public String viewHomePage() {
        return "index.html"; // return the html file name eg. index.html
    }

}

