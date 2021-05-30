package com.example.demo.boundary;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class LoginUI {

    @Autowired
    private UserRepository userRepo; // create object userRepo

    @GetMapping("") // map to home page url
    public String viewHomePage() {
        return "index.html";
    }
    @GetMapping("/hcorg")
    public String viewHealthOrgPage() {
        return "hcorg.html";
    }

    @GetMapping("/public")
    public String viewPublicPage() {
        return "public.html";
    }

    @GetMapping("/hcstaff")
    public String viewHealthStaffPage() {
        return "hcstaff.html";
    }

    @GetMapping("/business")
    public String viewBusinessPage() {
        return "business.html";
    }
}

