package com.springproject.webapp.service;

import com.springproject.webapp.dao.MultiplexJpaRepository;
import com.springproject.webapp.entity.Movie;
import com.springproject.webapp.entity.Multiplex;
import com.springproject.webapp.exception.multiplex.MultiplexNotFoundException;
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
            //Exception
            throw new MultiplexNotFoundException("Did not find multiplex with id - "+ theId);
        }
        return theMultiplex;
    }



    @Override
    public void saveMultiplex(Multiplex theMultiplex) {
        Multiplex tempMultiplex = multiplexJpaRepository.findByMultiplexName(theMultiplex.getMultiplexName());
        if (tempMultiplex != null && theMultiplex.getIdMultiplex() == 0){
            return ;
        }

            multiplexJpaRepository.save(theMultiplex);

    }

    @Override
    public void deleteMultiplexById(int theId) {

        multiplexJpaRepository.deleteById(theId);
    }



}
