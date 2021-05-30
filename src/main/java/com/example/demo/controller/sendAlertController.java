package com.example.demo.controller;

import javax.transaction.Transactional;

import java.util.List;

import com.example.demo.entity.*;
import com.example.demo.repository.AlertRepository;
import com.example.demo.repository.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class sendAlertController {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private AlertRepository alertRepository;

    public List<Record> getRecordInfoForPublic() {
        return recordRepository.findInfoPublic();
    }

    public List<Record> getRecordInfoForBusiness() {
        return recordRepository.findInfoBusiness();
    }

    public void sendAlert(String alert_id, String message, String user_id) {
        alertRepository.addInfo(alert_id, message, user_id);
    }

}
