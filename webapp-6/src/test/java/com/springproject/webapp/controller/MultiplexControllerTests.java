package com.springproject.webapp.controller;

import com.springproject.webapp.entity.Movie;
import com.springproject.webapp.entity.Multiplex;
import com.springproject.webapp.service.MovieService;
import com.springproject.webapp.service.MultiplexService;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.springproject.webapp.WebappApplication.class})
public class MultiplexControllerTests {

    @Mock
    MultiplexService multiplexService;

    @Mock
    MovieService movieService;

    @InjectMocks
    MultiplexController multiplexController;

    @Mock
    Model model;

    @Mock
    private BindingResult bindingResult;

    @Test
    public void findAllTest() {
        Multiplex multiplex1 = new Multiplex("PVR", 4, "Warangal");
        Multiplex multiplex2 = new Multiplex("Asian Sridevi", 4, "Warangal");

        List<Multiplex> multiplexList = new ArrayList<>();
        multiplexList.add(multiplex1);
        multiplexList.add(multiplex2);

        when(multiplexService.findAllMultiplex()).thenReturn(multiplexList);

        String viewName = multiplexController.findAll(model);

        Mockito.verify(multiplexService).findAllMultiplex();
        Mockito.verify(model).addAttribute("multiplex", multiplexList);
        assertEquals("multiplex/multiplexList", viewName);
    }

    @Test
    public void testBackToHome() {
        String viewName = multiplexController.backToHome();

        assertEquals("home", viewName);
    }

    @Test
    public void deleteMultiplexTest() {
        int multiplexId = 1;

        doNothing().when(multiplexService).deleteMultiplexById(multiplexId);
        String result = multiplexController.deleteMultiplex(multiplexId);

        Mockito.verify(multiplexService).deleteMultiplexById(multiplexId);

        assertEquals("redirect:/multiplex/list", result);
    }

    @Test
    public void showFormForAddTest() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("ABCD", "Dance", 4));
        movieList.add(new Movie("ABCD2", "Dance", 5));

        when(movieService.findAllMovies()).thenReturn(movieList);

        String result = multiplexController.showFormForAdd(model);
        Mockito.verify(model).addAttribute("movies", movieList);
        Mockito.verify(model).addAttribute("multiplex", new Multiplex());

        assertEquals("multiplex/multiplexForm", result);
    }

    @Test
    public void showFormForUpdateTest() {
        int multiplexId = 1;
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("ABCD", "Dance", 4));
        movieList.add(new Movie("ABCD2", "Dance", 5));

        Multiplex multiplex = new Multiplex();
        multiplex.setIdMultiplex(multiplexId);
        multiplex.setMultiplexName("S2");
        multiplex.setMovieList(movieList);

        when(movieService.findAllMovies()).thenReturn(movieList);

        when(multiplexService.findMultiplexById(multiplexId)).thenReturn(multiplex);

        String viewName = multiplexController.showFormForUpdate(multiplexId, model);

        assertEquals("multiplex/multiplexForm", viewName);
        Mockito.verify(model).addAttribute("multiplex", multiplex);
        Mockito.verify(model).addAttribute("movies", movieList);
        Mockito.verify(movieService).findAllMovies();
        Mockito.verify(multiplexService).findMultiplexById(multiplexId);
    }

    @Test
    public void addMultiplexTest_InValidCase() {

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("ABCD", "Dance", 4));
        movieList.add(new Movie("ABCD2", "Dance", 5));

        when(bindingResult.hasErrors()).thenReturn(true);
        when(movieService.findAllMovies()).thenReturn(movieList);

        String viewName = multiplexController.addMultiplex(new Multiplex(), bindingResult, model);
        assertEquals("multiplex/multiplexForm", viewName);
        Mockito.verify(movieService).findAllMovies();
    }

    @Test
    public void addMultiplexTest_ValidCase() {

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("ABCD", "Dance", 4));
        movieList.add(new Movie("ABCD2", "Dance", 5));

        when(bindingResult.hasErrors()).thenReturn(false);
        when(movieService.findAllMovies()).thenReturn(movieList);
        Multiplex multiplex = new Multiplex();
        String viewName = multiplexController.addMultiplex(multiplex, bindingResult, model);
        assertEquals("redirect:/multiplex/list", viewName);
        Mockito.verify(multiplexService).saveMultiplex(multiplex);
    }

}
