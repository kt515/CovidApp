package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

    @Autowired
    private UserRepository userRepo; // create object userRepo

    @GetMapping("") // map to home page url
    public String viewHomePage() {
        return "index.html"; // return the html file name eg. index.html
    }
    @GetMapping("/public")
    public String viewPublicPage() {
        return "This is public page";
    }
    @GetMapping("/business")
    public String viewBusinessPage() {
        return "This is Business page";
    }
    @GetMapping("/hcorg")
    public String viewHCOrgPage() {
        return "This is HCOrg page";
    }
    @GetMapping("/hcstaff")
    public String viewHCStaffPage() {
        return "This is HCStaff page";
    }
    @GetMapping("/logout")
    public String viewLogoutPage() {
        return "You have successfully logged out";
    }
}

