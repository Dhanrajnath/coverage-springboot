package com.springproject.multiplexinfoapp.service;

import com.springproject.multiplexinfoapp.entity.Movie;
import com.springproject.multiplexinfoapp.entity.Multiplex;

import java.util.List;

public interface MultiplexService {

    List<Multiplex> findAllMultiplex();

    Multiplex findMultiplexById(int theId);

    Multiplex addMovieInMultiplex(Movie theMovie);

    void saveMultiplex(Multiplex theMultiplex);

    void deleteMultiplexById(int theId);
}
