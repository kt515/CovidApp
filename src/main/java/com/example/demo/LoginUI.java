package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginUI {
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
