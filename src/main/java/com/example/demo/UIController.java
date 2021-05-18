package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class UIController {

    @Autowired
    private UserRepository userRepo; // create object userRepo

    @GetMapping("") // map to home page url
    public String viewHomePage() {
        return "index"; // return the html file name eg. index.html
    }

}

