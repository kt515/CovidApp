package com.example.demo.boundary;

import com.example.demo.controller.SearchUserController;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UISearchUser {
  @Autowired
  private SearchUserController controller;

    @RequestMapping("/hcorg")
    public String viewSearchUserPage(Model model, @Param("keyword") String keyword) {
        List<User> listUsers = controller.listAll(keyword);
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("keyword", keyword);
        return "HCOrganisation";
    }

}
