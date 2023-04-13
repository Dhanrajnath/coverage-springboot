package com.springproject.webapp.controller;

import com.springproject.webapp.entity.Multiplex;
import com.springproject.webapp.service.MovieService;
import com.springproject.webapp.service.MultiplexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.springproject.webapp.WebappApplication.class})
public class UserControllerTests {

    @Mock
    private Model model;
    @Mock
    private MultiplexService multiplexService;

    @Test
    public void backToHomeTest() {
        UserController userController = new UserController();
        assertEquals("home", userController.backToHome());
    }

}
