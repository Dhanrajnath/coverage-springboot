package com.springproject.webapp.service;


import com.springproject.webapp.entity.Multiplex;

import java.util.List;

public interface MultiplexService {

    List<Multiplex> findAllMultiplex();

    Multiplex findMultiplexById(int theId);

    void saveMultiplex(Multiplex theMultiplex);

    void deleteMultiplexById(int theId);
}
