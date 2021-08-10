package com.springproject.webapp.converter;

import com.springproject.webapp.dto.MultiplexDTO;
import com.springproject.webapp.entity.Multiplex;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MultiplexConverter {


    public MultiplexDTO entityToDto(Multiplex theMultiplex){
        ModelMapper mapper = new ModelMapper();
        MultiplexDTO map = mapper.map(theMultiplex,MultiplexDTO.class);
        return map;
    }

    public Multiplex dtoToEntity(MultiplexDTO theMultiplexDto){
        ModelMapper mapper = new ModelMapper();
        Multiplex map = mapper.map(theMultiplexDto,Multiplex.class);
        return map;
    }

    public List<MultiplexDTO> entityToDto(List<Multiplex> theMultiplexs){

        return theMultiplexs.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public List<Multiplex> dtoToEntity(List<MultiplexDTO> theMultiplexDtos){

        return theMultiplexDtos.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
