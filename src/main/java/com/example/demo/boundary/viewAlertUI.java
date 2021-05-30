package com.example.demo.boundary;

import java.util.List;

import com.example.demo.entity.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class viewAlertUI {

    @Autowired
    private com.example.demo.controller.viewAlertController viewAlertController;

    @RequestMapping("/public/viewAlert")
    public String viewPublicAlertPage(Model model) {
        List<Alert> showMsg = viewAlertController.getNotification();
        model.addAttribute("showMsg", showMsg);
        return "publicViewAlert.html";
    }

    @RequestMapping("/business/viewAlert")
    public String viewBusinessAlertPage(Model model) {
        List<Alert> showMsg = viewAlertController.getNotification();
        model.addAttribute("showMsg", showMsg);
        return "businessViewAlert.html";
    }

}