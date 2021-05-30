package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SearchUserController {

        @Autowired
        private UserRepository userRepository;
        @Autowired
        private PublicRepository publicRepository;
        @Autowired
        private BusinessRepository businessRepository;
        @Autowired
        private HealthOrgRepository healthOrgRepository;
        @Autowired
        private HealthStaffRepository healthStaffRepository;

        public List<User> listAllUser(String keyword) {  // list all users
            if (keyword != null) {
                return userRepository.search(keyword);
            }
            return userRepository.findAll();
        }

        public List<Public> listAllPublic() {
           return publicRepository.findAll();
        }

        public List<Business> listAllBusiness() {
            return businessRepository.findAll();
        }

        public List<HealthOrg> listAllHealthOrg() {
            return healthOrgRepository.findAll();
        }

        public List<HealthStaff> listAllHealthStaff() {
            return healthStaffRepository.findAll();
        }
}




