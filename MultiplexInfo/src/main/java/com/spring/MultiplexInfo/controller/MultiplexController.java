package com.spring.MultiplexInfo.controller;

import com.spring.MultiplexInfo.entity.Movie;
import com.spring.MultiplexInfo.entity.Multiplex;
import com.spring.MultiplexInfo.service.MovieService;
import com.spring.MultiplexInfo.service.MultiplexService;
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

    @Autowired
    private MovieService movieService;

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

        List<Movie> theMovies = movieService.findAllMovies();
        theModel.addAttribute("movies",theMovies);

        theModel.addAttribute("multiplex", theMultiplex);

        return "multiplex/multiplexForm";
    }

    @GetMapping("/showFormForMultiplexUpdate")
    public String showFormForUpdate(@RequestParam("multiplex_id") int theId,
                                    Model theModel) {
        List<Movie> movies = movieService.findAllMovies();

        Multiplex theMultiplex = multiplexService.findMultiplexById(theId);
        theModel.addAttribute("multiplex", theMultiplex);
        theModel.addAttribute("movies",movies);

        // send over to our form
        return "multiplex/multiplexForm";
    }


    @PostMapping("/addMultiplex")
    public String addMultiplex(@Valid @ModelAttribute("multiplex") Multiplex theMultiplex, BindingResult theBindingResult,
                                Model theModel) {

        if(theBindingResult.hasErrors())
        {
            List<Movie> movies = movieService.findAllMovies();

                theModel.addAttribute("movies",movies);
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
            throw new RuntimeException("id not found - " + multiplexId);
        }

        multiplexService.deleteMultiplexById(multiplexId);

        return "redirect:/multiplex/list";
    }


}


