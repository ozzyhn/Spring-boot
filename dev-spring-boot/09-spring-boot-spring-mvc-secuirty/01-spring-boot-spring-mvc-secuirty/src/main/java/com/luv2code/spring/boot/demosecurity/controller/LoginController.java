package com.luv2code.spring.boot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage") // spring security kodlamasındaki showMyLoginPage ile eşleşiyor
    public String showMyLoginPage () {


        return"fancy-login.html"; //src/main/resources/template/plain-login.html döndürüyoruz
    }

    // add request mapping for denied page
    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }
}
