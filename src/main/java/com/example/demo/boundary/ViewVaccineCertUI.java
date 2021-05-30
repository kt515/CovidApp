package com.example.demo.boundary;

import java.util.List;

import com.example.demo.entity.VaccineCert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewVaccineCertUI {

    @Autowired
    private com.example.demo.controller.VaccineCertController VaccineCertController;

    @RequestMapping("/public/viewVaccineCert")
    public String VaccineCertPage(Model model) {
        List<VaccineCert> showCert = VaccineCertController.getNotification();
        model.addAttribute("showCert", showCert);
        return "VaccineCert.html";
    }

}