package com.springproject.webapp.converter;

import com.springproject.webapp.dto.MovieDTO;
import com.springproject.webapp.entity.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieConverter {


    public MovieDTO entityToDto(Movie theMovie){
        ModelMapper mapper = new ModelMapper();
        MovieDTO map = mapper.map(theMovie,MovieDTO.class);
        return map;
    }

    public Movie dtoToEntity(MovieDTO theMovieDto){
        ModelMapper mapper = new ModelMapper();
        Movie map = mapper.map(theMovieDto,Movie.class);
        return map;
    }

    public List<MovieDTO> entityToDto(List<Movie> theMovies){

        return theMovies.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public List<Movie> dtoToEntity(List<MovieDTO> theMovieDtos){

        return theMovieDtos.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
