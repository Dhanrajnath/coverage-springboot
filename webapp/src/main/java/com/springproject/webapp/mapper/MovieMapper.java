package com.springproject.webapp.mapper;

import com.springproject.webapp.dto.MovieDTO;
import com.springproject.webapp.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MovieMapper
{
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDTO EntityToDto(Movie theMovie);
    Movie DtoToEntity(MovieDTO theMovieDTO);

    List<MovieDTO> EntitiesToDtos(List<Movie> theMovies);
    List<Movie> DtosToEntities(List<MovieDTO> theMovieDTOs);
}