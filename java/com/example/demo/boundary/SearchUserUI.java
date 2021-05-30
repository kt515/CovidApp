package com.example.demo.boundary;

import com.example.demo.controller.SearchUserController;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class SearchUserUI {
  @Autowired
  private SearchUserController controller;

    @RequestMapping("/hcorg/list_user")
    public String viewSearchUserPage(Model model, @Param("keyword") String keyword) {
        List<User> listUsers = controller.listAllUser(keyword);
        List<Public> listPublic = controller.listAllPublic();
        List<Business> listBusiness = controller.listAllBusiness();
        List<HealthOrg> listHealthOrg = controller.listAllHealthOrg();
        List<HealthStaff> listHealthStaff = controller.listAllHealthStaff();
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("listPublic", listPublic);
        model.addAttribute("listBusiness", listBusiness);
        model.addAttribute("listHealthOrg", listHealthOrg);
        model.addAttribute("listHealthStaff", listHealthStaff);
        model.addAttribute("keyword", keyword);
        return "list_usernew";
    }

}
