package com.udemy.backendninja.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {
    public static void main(String[] args) {
        BCryptPasswordEncoder c = new BCryptPasswordEncoder();
        System.out.println(c.encode("admin"));
    }
}
