package com.springproject.webapp.controller;


import com.springproject.webapp.dto.MovieDTO;
import com.springproject.webapp.entity.Movie;
import com.springproject.webapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping("/list")
    public String findAll(Model theModel){

        List<Movie> theMovies = movieService.findAllMovies();

        theModel.addAttribute("movies",theMovies);

        return "movie/movieList";
    }

    @GetMapping("/showFormForAddMovie")
    public String showFormForAdd(Model theModel) {

        MovieDTO theMovie = new MovieDTO();
        theMovie.setIdMovie(0);
        theModel.addAttribute("movie", theMovie);

        return "movie/movieForm";
    }

    @GetMapping("/showFormForMovieUpdate")
    public String showFormForUpdate(@RequestParam("movie_id") int theId,
                                    Model theModel) {

        MovieDTO theMovie = movieService.findMovieById(theId);


        theModel.addAttribute("movie", theMovie);

        // send over to our form
        return "movie/movieForm";
    }


    @PostMapping("/addMovie")
    public String addMovie(@Valid @ModelAttribute("movie") Movie theMovie, BindingResult theBindingResult) {


        if(theBindingResult.hasErrors())
        {
            return "movie/movieForm";
        }
        else
        {
            movieService.saveMovie(theMovie);
            return "redirect:/movie/list";
        }
    }


    @GetMapping("/deleteMovie")
    public String deleteMovie(@RequestParam("movie_id") int movieId) {

        MovieDTO tempMovie = movieService.findMovieById(movieId);

//        Movie tempMovie = movieService.findMovieById(movieId);


        if (tempMovie == null) {
            throw new RuntimeException("Employee id not found - " + movieId);
        }

        movieService.deleteMovieById(movieId);

        return "redirect:/movie/list";
    }


    @GetMapping("/backToHome")
    public String backToHome(){

        return "home";
    }




}
