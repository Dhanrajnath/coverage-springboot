package com.spring.MultiplexInfo.controller;

import com.spring.MultiplexInfo.entity.Movie;
import com.spring.MultiplexInfo.service.MovieService;
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

        Movie theMovie = new Movie();
        theMovie.setIdMovie(0);

        theModel.addAttribute("movie", theMovie);

        return "movie/movieForm";
    }

    @GetMapping("/showFormForMovieUpdate")
    public String showFormForUpdate(@RequestParam("movie_id") int theId,
                                    Model theModel) {

        Movie theMovie = movieService.findMovieById(theId);

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

        Movie tempMovie = movieService.findMovieById(movieId);


        if (tempMovie == null) {
            throw new RuntimeException("Employee id not found - " + movieId);
        }

        movieService.deleteMovieById(movieId);

        return "redirect:/movie/list";
    }






}