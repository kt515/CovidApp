package com.example.demo.boundary;

import java.util.List;

import com.example.demo.controller.ViewHistoryLocationController;
import com.example.demo.entity.Record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewHistoryLocationUI {

    @Autowired
    private ViewHistoryLocationController viewLocationController;

    @RequestMapping("/public/ViewRecord")
    public String viewRecordPage(Model model){
        List<Record> listRecords = viewLocationController.listAll();
        model.addAttribute("listRecords", listRecords);
        return "ViewRecord.html";
    }
}
