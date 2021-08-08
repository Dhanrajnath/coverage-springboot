package com.springproject.webapp.controller;


import com.springproject.webapp.entity.Movie;
import com.springproject.webapp.entity.Multiplex;
import com.springproject.webapp.service.MovieService;
import com.springproject.webapp.service.MultiplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


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


    @GetMapping("/visitMovie")
    public String visitMovie(Model theModel,@RequestParam("multiplex_id") int theMultiplexId){

        List<Movie> theMovies = movieService.findAllMovies();
        theModel.addAttribute("movies",theMovies);

        return "multiplex/movieslist";
    }
    @GetMapping("/addmovie")
    public String addMovie(Model theModel, @RequestParam("movie_id") int theId){


        Movie theMovie = movieService.findMovieById(theId);

        Multiplex theMultiplex = new Multiplex();
        theMultiplex.addMovie(theMovie);

        theModel.addAttribute("multiplex_movie", theMultiplex);

        System.out.println(theMultiplex.getMovie());

        return "redirect:multiplex/list";
    }

}


