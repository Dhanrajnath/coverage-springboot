package com.springproject.webapp.service;

import com.springproject.webapp.converter.MovieConverter;
import com.springproject.webapp.dao.MovieJpaRepository;
import com.springproject.webapp.dto.MovieDTO;
import com.springproject.webapp.entity.Movie;
import com.springproject.webapp.exception.movie.MovieNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.springproject.webapp.WebappApplication.class})
class MovieServiceTests {

    private MovieService movieService;

    @Mock
    private MovieJpaRepository mockRepository;

    @Mock
    private MovieConverter movieConverter;

    @BeforeEach
    void initUseCase() {
        movieService = new MovieServiceImpl(mockRepository, movieConverter);
    }

    @Test
    void findByIdMocked() {
        MovieConverter mapper = new MovieConverter();

        Movie movie = new Movie("ABCD", "Dance", 4);
        when(mockRepository.findById(1)).thenReturn(java.util.Optional.of(movie));
        assertEquals(movie, mapper.dtoToEntity(movieService.findMovieById(1)));
        verify(mockRepository).findById(1);
    }

    @Test
    void findByIdMocked_ThrowsMovieNotFoundException() {
        when(mockRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(MovieNotFoundException.class, () -> movieService.findMovieById(1));
        verify(mockRepository).findById(1);
    }

    @Test
    void findAllMoviesTest() {
        when(mockRepository.findAll()).thenReturn(Stream.of(new Movie("ABCD", "Dance", 4), new Movie("ABCD", "Dance", 4)).collect(Collectors.toList()));
        assertEquals(2, movieService.findAllMovies().size());
    }

    @Test
    void deleteMovieTest() {
        movieService.deleteMovieById(1);
        verify(mockRepository).deleteById(1);
    }

    @Test
    void saveMovieTest() {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieTitle("Test Movie");

        Movie movie = new Movie();

        when(movieConverter.dtoToEntity(movieDTO)).thenReturn(movie);

        when(mockRepository.findByMovieTitle("Test Movie")).thenReturn(null);

        movieService.saveMovie(movieDTO);

        verify(movieConverter, times(1)).dtoToEntity(movieDTO);
        verify(mockRepository, times(1)).save(movie);

    }
}
