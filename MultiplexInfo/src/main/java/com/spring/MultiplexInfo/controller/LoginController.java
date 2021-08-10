package com.spring.MultiplexInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
    @GetMapping("/")
    public String homePage()
    {
        return "home";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage()
    {
        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
}
