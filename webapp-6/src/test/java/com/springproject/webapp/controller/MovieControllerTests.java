package com.springproject.webapp.controller;

import com.springproject.webapp.dto.MovieDTO;
import com.springproject.webapp.entity.Movie;
import com.springproject.webapp.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.springproject.webapp.WebappApplication.class})
public class MovieControllerTests {

    @Mock
    MovieService movieService;

    @InjectMocks
    MovieController movieController;

    @Mock
    Model model;

    @Mock
    private BindingResult bindingResult;

    @Test
    public void findAllTest() {

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("ABCD", "Dance", 4));
        movieList.add(new Movie("ABCD2", "Dance", 5));

        when(movieService.findAllMovies()).thenReturn(movieList);

        assertEquals("movie/movieList", movieController.findAll(model));
    }

    @Test
    public void showFormForAddTest() {

        assertEquals("movie/movieForm", movieController.showFormForAdd(model));
        // capturing the argument passed to the model i.e.,  () -> movieDTO
        ArgumentCaptor<MovieDTO> argumentCaptor = ArgumentCaptor.forClass(MovieDTO.class);
        Mockito.verify(model).addAttribute(eq("movie"), argumentCaptor.capture());
        MovieDTO actualMovie = argumentCaptor.getValue();
        assertEquals(0, actualMovie.getIdMovie());
    }

    @Test
    public void showFormForUpdateTest() {
        // Arrange
        int movieId = 1;
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setIdMovie(movieId);
        movieDTO.setMovieTitle("DASARA");

        when(movieService.findMovieById(movieId)).thenReturn(movieDTO);

        // Act
        // Assert
        assertEquals("movie/movieForm", movieController.showFormForUpdate(1, model));

        ArgumentCaptor<MovieDTO> argumentCaptor = ArgumentCaptor.forClass(MovieDTO.class);
        Mockito.verify(model).addAttribute(eq("movie"), argumentCaptor.capture());
        MovieDTO actualMovie = argumentCaptor.getValue();
        assertEquals(movieId, actualMovie.getIdMovie());
        assertEquals(movieDTO.getMovieTitle(), actualMovie.getMovieTitle());

    }

    @Test
    public void addMovieTest_WithValidInput() {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieTitle("DASARA");
        movieDTO.setMovieType("Action Drama");

        when(bindingResult.hasErrors()).thenReturn(false);
        assertEquals("redirect:/movie/list", movieController.addMovie(movieDTO, bindingResult));
        Mockito.verify(movieService).saveMovie(movieDTO);
    }

    @Test
    public void addMovieTest_WithInValidInput() {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieTitle("DASARA");
        movieDTO.setMovieType("Action Drama");

        when(bindingResult.hasErrors()).thenReturn(true);
        assertEquals("movie/movieForm", movieController.addMovie(movieDTO, bindingResult));
    }

    @Test
    public void deleteMovieTest() {

        int movieId = 1;
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieTitle("DASARA");

        when(movieService.findMovieById(movieId)).thenReturn(movieDTO);

        String viewName = movieController.deleteMovie(movieId);

        Mockito.verify(movieService).deleteMovieById(movieId);
        assertEquals("redirect:/movie/list", viewName);
    }

    @Test
    public void testBackToHome() {
        String viewName = movieController.backToHome();

        assertEquals("home", viewName);
    }
}
