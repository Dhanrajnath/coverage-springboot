package com.springproject.multiplexinfoapp.service;

import com.springproject.multiplexinfoapp.dao.MultiplexRepository;
import com.springproject.multiplexinfoapp.entity.Movie;
import com.springproject.multiplexinfoapp.entity.Multiplex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MultiplexServiceImpl implements MultiplexService{

    private MultiplexRepository multiplexRepository;



    @Autowired
    public MultiplexServiceImpl(MultiplexRepository multiplexRepository) {
        this.multiplexRepository = multiplexRepository;
    }

    @Override
    public List<Multiplex> findAllMultiplex() {
        return multiplexRepository.findAll();
    }

    @Override
    public Multiplex findMultiplexById(int theId) {
        Optional<Multiplex> result = multiplexRepository.findById(theId);

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
        multiplexRepository.save(theMultiplex);
    }

    @Override
    public void deleteMultiplexById(int theId) {
        multiplexRepository.deleteById(theId);
    }



}