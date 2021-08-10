package com.spring.MultiplexInfo.service;


import com.spring.MultiplexInfo.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAllMovies();

    Movie findMovieById(int theId);

    void deleteMovieById(int theId);

    void saveMovie(Movie theMovie);
}
