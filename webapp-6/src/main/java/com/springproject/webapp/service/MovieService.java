package com.springproject.webapp.service;


import com.springproject.webapp.dto.MovieDTO;
import com.springproject.webapp.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAllMovies();

    MovieDTO findMovieById(int theId);

    void deleteMovieById(int theId);

    void saveMovie(Movie theMovie);
}
