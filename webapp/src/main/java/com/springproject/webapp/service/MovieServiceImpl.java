package com.springproject.webapp.service;

import com.springproject.webapp.dao.MovieRepository;
import com.springproject.webapp.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;


    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;

    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findMovieById(int theId) {
        Optional<Movie> result = movieRepository.findById(theId);

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

        movieRepository.save(theMovie);
    }


    @Override
    public void deleteMovieById(int theId) {
        movieRepository.deleteById(theId);
    }
}
