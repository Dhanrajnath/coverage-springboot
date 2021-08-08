package com.springproject.webapp.service;

import com.springproject.webapp.dao.MultiplexRepository;

import com.springproject.webapp.entity.Multiplex;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MultiplexServiceImpl implements MultiplexService{

    private MultiplexRepository multiplexRepository;

    private ModelMapper mapper;

    @Autowired
    public MultiplexServiceImpl(MultiplexRepository multiplexRepository, ModelMapper mapper) {
        this.multiplexRepository = multiplexRepository;
        this.mapper = mapper;
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
            throw new RuntimeException("Did not find employee id - "+ theId);
        }
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
