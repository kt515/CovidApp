package com.example.demo.boundary;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import com.example.demo.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class sendAlertUI {

    @Autowired
    private com.example.demo.controller.sendAlertController sendAlertController;

    @RequestMapping("/hcstaff/sendAlert")
    public String viewAlertPage(Model model) {
        List<Record> pubInfo = sendAlertController.getRecordInfoForPublic();
        List<Record> busInfo = sendAlertController.getRecordInfoForBusiness();
        model.addAttribute("pubInfo", pubInfo);
        model.addAttribute("busInfo", busInfo);
        return "sendAlert.html";
    }

    @RequestMapping("/hcstaff/sendAlert/sendPub/{id}/{store_name}/{store_address}/{date_visited}")
    public String addAlertPub(@PathVariable(name = "id") String user_id,
            @PathVariable(name = "store_name") String store_name,
            @PathVariable(name = "store_address") String store_address,
            @PathVariable(name = "date_visited") Date date_visited) {

        Random random = new Random();
        int randomWithNextInt = random.nextInt(10000000) + 1;
        String alert_id = Integer.toString(randomWithNextInt);

        String message = "You are in close contact recently at " + store_name + ", " + store_address + " on the "
                + date_visited + " .";

        sendAlertController.sendAlert(alert_id, message, user_id);

        return "redirect:/hcstaff/sendAlert";
    }

    @RequestMapping("/hcstaff/sendAlert/sendBus/{id}")
    public String addAlertBus(@PathVariable(name = "id") String user_id) {

        Random random = new Random();
        int randomWithNextInt = random.nextInt(10000000) + 1;
        String alert_id = Integer.toString(randomWithNextInt);

        String message = "Your establishent are in close contact with recent covid cases. Please sanitise your area.";

        sendAlertController.sendAlert(alert_id, message, user_id);

        return "redirect:/hcstaff/sendAlert";
    }
}
