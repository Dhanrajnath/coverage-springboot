package com.springproject.webapp.dao;

import com.springproject.webapp.converter.MovieConverter;
import com.springproject.webapp.entity.Movie;
import com.springproject.webapp.service.MovieService;
import com.springproject.webapp.service.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.springproject.webapp.WebappApplication.class})
class WebappApplicationTests {

    @Test
    void contextLoads() {
    }

}
