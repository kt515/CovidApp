package com.example.demo.boundary;

import java.util.List;

import com.example.demo.BusinessSearchUserForm;
import com.example.demo.controller.BusinessSearchUserController;
import com.example.demo.entity.Public;
import com.example.demo.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BusinessSearchUserUI {
    
    @Autowired
    private BusinessSearchUserController businessSearchUserController;

    @GetMapping("/business/SearchUser")
    public String viewBusinessSearchUserPageForm(Model model){
        model.addAttribute("businessSearchUserForm", new BusinessSearchUserForm());
        
        return "BusinessSearchUserForm";
    }

    @PostMapping("/business/SearchUser")
    public String viewBusinessSearchUserPageSubmit(@ModelAttribute BusinessSearchUserForm businessSearchUserForm, Model model){
        List<Record> listRecords = businessSearchUserController.listAllRec(businessSearchUserForm.getDate());
        System.out.println("HEREEE");
        System.out.println(listRecords.size());
        
        List<Public> listPublics = businessSearchUserController.listAllPub();
        System.out.println("HEREEE AFTER");
        System.out.println(listPublics.size());

        for (Public pub : listPublics) {
            try {
                System.out.println(pub.getPublicId().getFirst_name());
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }

        model.addAttribute("listRecords", listRecords);
        model.addAttribute("listPublics", listPublics);
        System.out.println("im leaving");
        
        return "BusinessSearchUserResult";
    }
}
