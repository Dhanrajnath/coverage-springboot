package com.spring.MultiplexInfo.controller;

import com.spring.MultiplexInfo.entity.Multiplex;
import com.spring.MultiplexInfo.service.MovieService;
import com.spring.MultiplexInfo.service.MultiplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private MultiplexService multiplexService;

    @GetMapping("/")
    public String display(Model theModel)
    {
        List<Multiplex> theMultiplex = multiplexService.findAllMultiplex();
        theModel.addAttribute("multiplex",theMultiplex);

        return "user/displayMovies";
    }

}
