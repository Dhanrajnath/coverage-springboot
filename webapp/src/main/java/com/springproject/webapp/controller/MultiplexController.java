package com.springproject.webapp.controller;

import com.springproject.webapp.entity.Multiplex;
import com.springproject.webapp.service.MultiplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/multiplex")
public class MultiplexController {

    @Autowired
    private MultiplexService multiplexService;


    @GetMapping("/list")
    public String findAll(Model theModel){

        List<Multiplex> theMultiplex = multiplexService.findAllMultiplex();

        theModel.addAttribute("multiplex",theMultiplex);

        return "multiplex/multiplexList";
    }

    @GetMapping("/showFormForAddMultiplex")
    public String showFormForAdd(Model theModel) {


        Multiplex theMultiplex = new Multiplex();
        theMultiplex.setIdMultiplex(0);

        theModel.addAttribute("multiplex", theMultiplex);

        return "multiplex/multiplexForm";
    }

    @GetMapping("/showFormForMultiplexUpdate")
    public String showFormForUpdate(@RequestParam("multiplex_id") int theId,
                                    Model theModel) {

        Multiplex theMultiplex = multiplexService.findMultiplexById(theId);
        theModel.addAttribute("multiplex", theMultiplex);

        // send over to our form
        return "multiplex/multiplexForm";
    }


    @PostMapping("/addMultiplex")
    public String addMultiplex(@Valid @ModelAttribute("multiplex") Multiplex theMultiplex, BindingResult theBindingResult) {


        if(theBindingResult.hasErrors())
        {
            System.out.println(theBindingResult.hasErrors());
            return "multiplex/multiplexForm";
        }
        else
        {
            multiplexService.saveMultiplex(theMultiplex);
            return "redirect:/multiplex/list";
        }
    }


    @GetMapping("/deleteMultiplex")
    public String deleteMultiplex(@RequestParam("multiplex_id") int multiplexId) {

        Multiplex tempMultiplex = multiplexService.findMultiplexById(multiplexId);


        if (tempMultiplex == null) {
            throw new RuntimeException("Employee id not found - " + multiplexId);
        }

        multiplexService.deleteMultiplexById(multiplexId);

        return "redirect:/multiplex/list";
    }



    @GetMapping("/visitMovies")
    public String visitMovies(@RequestParam("multiplex_id") int theId,Model theModel) {

        return "visitMovies";
    }

    @GetMapping("/addMovie")
    public String addMovie(){

        return "movies";
    }


}
