package com.springproject.webapp.controller;

import com.springproject.webapp.entity.Multiplex;
import com.springproject.webapp.service.MultiplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private MultiplexService multiplexService;


    @GetMapping("/showInfo")
    public String display(Model theModel)
    {
        List<Multiplex> theMultiplex = multiplexService.findAllMultiplex();
        theModel.addAttribute("multiplex",theMultiplex);

        return "user/displayMovies";
    }

}
