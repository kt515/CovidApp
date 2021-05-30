package com.example.demo.boundary;


import java.util.Optional;

import com.example.demo.HealthStaffSearchUserForm;
import com.example.demo.controller.HealthStaffUpdateCertController;
import com.example.demo.entity.VaccineCert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HealthStaffUpdateCertUI {
    
    @Autowired
    private HealthStaffUpdateCertController healthStaffUpdateCertController;

    @GetMapping("/hcstaff/SearchUser")
    public String viewHealthStaffSearchUserPageForm(Model model){

        model.addAttribute("HealthStaffSearchUserForm", new HealthStaffSearchUserForm());
        
        return "HealthStaffSearchUserForm";
    }

    @PostMapping("/hcstaff/SearchUser")
    public String viewHealthStaffSearchUserPageResult(@ModelAttribute HealthStaffSearchUserForm healthStaffSearchUserForm, Model model){

        VaccineCert listCert = healthStaffUpdateCertController.getUser(healthStaffSearchUserForm.getId());
        model.addAttribute("listCert", listCert);

        return "HealthStaffSearchUserResult";
    }

    @RequestMapping("/hcstaff/SearchUser/Edit/{id}")
    public String viewHealthStaffEditForm(@PathVariable("id") Optional<String> id, Model model) {

        VaccineCert vaccineCert = healthStaffUpdateCertController.getUser(id.get());
        model.addAttribute("vaccineCert", vaccineCert);

        return "HealthStaffEditCertForm";
    }

    @PostMapping("/hcstaff/SearchUser/Edit/Save")
    public String viewHealthStaffEditSave(@ModelAttribute VaccineCert vaccineCert, Model model){

        healthStaffUpdateCertController.updateCert(vaccineCert.getDate(), vaccineCert.getTime(), vaccineCert.getVaccine_location(), vaccineCert.getCert_id());
        return "redirect:/hcstaff/SearchUser";
    }
    
}
