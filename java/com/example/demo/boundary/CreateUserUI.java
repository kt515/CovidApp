package com.example.demo.boundary;

import com.example.demo.controller.CreateUserController;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateUserUI {

    @Autowired
    CreateUserController controller;

    @RequestMapping(path = "/hcorg/list_user/create")
    public String viewCreatePage(Model model)
    {
        return "create";
    }


    @RequestMapping(path = "/hcorg/list_user/createUser")
    public String viewCreateUserPage(Model model)
    {
        model.addAttribute("user",new User());
        return "create_user";
    }

    @RequestMapping(path = "/hcorg/list_user/createPublic")
    public String viewCreatePublicPage(Model model)
    {
        model.addAttribute("aPublic",new Public());
        return "create_public";
    }

    @PostMapping("/hcorg/list_user/createUser")
    public String createUser(@ModelAttribute User user, Model model)
    {
        controller.createUser(user.getId(), user.getPassword(), user.getRoles());
        return "redirect:/hcorg";
    }

    @PostMapping("/hcorg/list_user/createPublic")
    public String createPublic(@ModelAttribute Public aPublic, Model model)
    {
        controller.createPublic(aPublic.getPublicId().getPublic_userid(),
                aPublic.getPublicId().getFirst_name(), aPublic.getPublicId().getLastName(),
                aPublic.getPublicId().getDob(), aPublic.getContact_no(),
                aPublic.getResidential_address(), aPublic.isPositive_case(), aPublic.isVaccinated());
        return "redirect:/hcorg";
    }
}
