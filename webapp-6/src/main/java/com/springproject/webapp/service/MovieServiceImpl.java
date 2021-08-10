package com.springproject.webapp.service;

import com.springproject.webapp.converter.MovieConverter;
import com.springproject.webapp.dao.MovieJpaRepository;
import com.springproject.webapp.dto.MovieDTO;
import com.springproject.webapp.entity.Movie;
import com.springproject.webapp.exception.movie.MovieNotFoundException;
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
    public MovieDTO findMovieById(int theId) {
        Optional<Movie> result = movieJpaRepository.findById(theId);
        MovieConverter movieConverter = new MovieConverter();
        Movie theMovie =null;

        if (result.isPresent()){
            theMovie = result.get();
        }
        else {
            // Exception
            throw new MovieNotFoundException("Did not find movie with id - "+ theId);
        }
        return movieConverter.entityToDto(theMovie);
    }

    @Override
    public void saveMovie(Movie theMovie) {

        Movie tempMovie = movieJpaRepository.findByMovieTitle(theMovie.getMovieTitle());
        if (tempMovie != null && theMovie.getIdMovie() == 0){
            return ;
        }

        movieJpaRepository.save(theMovie);
    }


    @Override
    public void deleteMovieById(int theId) {
        movieJpaRepository.deleteById(theId);
    }
}
