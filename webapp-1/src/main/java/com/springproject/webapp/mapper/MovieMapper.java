package com.springproject.webapp.mapper;

import java.util.List;

import com.springproject.webapp.dto.MovieDTO;
import com.springproject.webapp.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDTO EntityToDto(Movie theMovie);
    Movie DtoToEntity(MovieDTO theMovieDTO);

    List<MovieDTO> EntitiesToDtos(List<Movie> theMovies);
    List<Movie> DtosToEntities(List<MovieDTO> theMovieDTOs);


}
