package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UISearchUser {
  @Autowired
  private SearchUserController controller;

    /*@RequestMapping("/hcorg")
    public String viewHomePage(Model model) {
        List<User> listUsers = controller.listAll();
        model.addAttribute("listProducts", listUsers);
        return "HCOrganisation";
    }*/

}