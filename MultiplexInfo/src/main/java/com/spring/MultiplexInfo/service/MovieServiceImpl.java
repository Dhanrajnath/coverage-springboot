package com.spring.MultiplexInfo.service;

import com.spring.MultiplexInfo.dao.MovieJpaRepository;
import com.spring.MultiplexInfo.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieJpaRepository movieJpaRepository;


    @Autowired
    public MovieServiceImpl(MovieJpaRepository movieJpaRepository) {
        this.movieJpaRepository = movieJpaRepository;

    }

    @Override
    public List<Movie> findAllMovies() {
        return movieJpaRepository.findAll();
    }

    @Override
    public Movie findMovieById(int theId) {
        Optional<Movie> result = movieJpaRepository.findById(theId);

        Movie theMovie =null;

        if (result.isPresent()){
            theMovie = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find id - "+ theId);
        }
        return theMovie;
    }

    @Override
    public void saveMovie(Movie theMovie) {

        movieJpaRepository.save(theMovie);
    }


    @Override
    public void deleteMovieById(int theId) {
        movieJpaRepository.deleteById(theId);
    }
}
