package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawpw = "aaronlake";
        String encodedPassword = encoder.encode(rawpw);

        System.out.println(encodedPassword);
    }
}
