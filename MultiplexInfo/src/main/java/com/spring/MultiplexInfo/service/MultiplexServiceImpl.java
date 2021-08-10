package com.spring.MultiplexInfo.service;

import com.spring.MultiplexInfo.dao.MultiplexJpaRepository;
import com.spring.MultiplexInfo.entity.Movie;
import com.spring.MultiplexInfo.entity.Multiplex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MultiplexServiceImpl implements MultiplexService{

    private MultiplexJpaRepository multiplexJpaRepository;



    @Autowired
    public MultiplexServiceImpl(MultiplexJpaRepository multiplexJpaRepository) {
        this.multiplexJpaRepository = multiplexJpaRepository;
    }

    @Override
    public List<Multiplex> findAllMultiplex() {
        return multiplexJpaRepository.findAll();
    }

    @Override
    public Multiplex findMultiplexById(int theId) {
        Optional<Multiplex> result = multiplexJpaRepository.findById(theId);

        Multiplex theMultiplex =null;

        if (result.isPresent()){
            theMultiplex = result.get();
        }
        else {
            throw new RuntimeException("Did not find id - "+ theId);
        }
        return theMultiplex;
    }


    @Override
    public Multiplex addMovieInMultiplex(Movie theMovie) {
        Multiplex theMultiplex = new Multiplex();
        theMultiplex.addMovie(theMovie);
        return theMultiplex;
    }


    @Override
    public void saveMultiplex(Multiplex theMultiplex) {
        multiplexJpaRepository.save(theMultiplex);
    }

    @Override
    public void deleteMultiplexById(int theId) {
        multiplexJpaRepository.deleteById(theId);
    }



}
