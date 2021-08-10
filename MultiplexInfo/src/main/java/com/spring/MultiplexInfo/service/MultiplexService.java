package com.spring.MultiplexInfo.service;


import com.spring.MultiplexInfo.entity.Movie;
import com.spring.MultiplexInfo.entity.Multiplex;

import java.util.List;

public interface MultiplexService {

    List<Multiplex> findAllMultiplex();

    Multiplex findMultiplexById(int theId);

    Multiplex addMovieInMultiplex(Movie theMovie);

    void saveMultiplex(Multiplex theMultiplex);

    void deleteMultiplexById(int theId);
}
