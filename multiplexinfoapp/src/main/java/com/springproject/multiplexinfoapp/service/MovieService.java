package com.springproject.multiplexinfoapp.service;

import com.springproject.multiplexinfoapp.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAllMovies();

    Movie findMovieById(int theId);

    void deleteMovieById(int theId);

    void saveMovie(Movie theMovie);
}
