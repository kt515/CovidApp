package com.example.demo.boundary;

import com.example.demo.controller.UpdateUserController;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Controller
public class UpdateUserUI {

    @Autowired
    private UpdateUserController controller;

    @RequestMapping(path = {"/hcorg/list_user/update/{id}"})
    public String viewUpdatePage(Model model, @PathVariable("id") Optional<String> id){
       User user = controller.getUserByUsername(id.get());
       Public apublic = controller.getPublicByUsername(id.get());

       model.addAttribute("user", user);
       model.addAttribute("apublic", apublic);

       return "update";
    }

    @RequestMapping("/hcorg/list_user/update/{id}/user") // updateUserpage
    public String viewUpdateUserPage(Model model, @PathVariable("id") Optional<String> id)
    {
        User user = controller.getUserByUsername(id.get());
        model.addAttribute("user", user);
        return "update_user";
    }

    @RequestMapping("/hcorg/list_user/update/{id}/public") // updatePublicPage
    public String viewUpdatePublicPage(Model model, @PathVariable("id") Optional<String> id)
    {
        Public aPublic = controller.getPublicByUsername(id.get());
        model.addAttribute("aPublic", aPublic);
        System.out.println(aPublic);
        return "update_public";
    }


    @PostMapping("/saveUser") //save to db
    public String saveUser(@ModelAttribute User user, Model model)
    {
        controller.updateUser(user.getId(), user.getPassword(), user.getRoles());
        return "redirect:/hcorg";
    }

    @PostMapping("/savePublic") // save to db
    public String savePublic(@ModelAttribute Public apublic, Model model)
    {
        controller.updatePublic((apublic.getPublicId().getPublic_userid()),
                apublic.getPublicId().getFirst_name(), apublic.getPublicId().getLastName(),
                apublic.getPublicId().getDob(), apublic.getContact_no(), apublic.getResidential_address());

        return "redirect:/hcorg";
    }
}
