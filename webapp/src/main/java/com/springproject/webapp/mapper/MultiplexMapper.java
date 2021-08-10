package com.springproject.webapp.mapper;

import com.springproject.webapp.dto.MultiplexDTO;
import com.springproject.webapp.entity.Multiplex;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MultiplexMapper
{
    MultiplexMapper INSTANCE = Mappers.getMapper(MultiplexMapper.class);

//    @Mapping(source = "Multiplex.id" , target = "theId")
    MultiplexDTO EntityToDto(Multiplex theMultiplex);
    Multiplex DtoToEntity(MultiplexDTO theMultiplexDTO);

    List<MultiplexDTO> EntitiesToDtos(List<Multiplex> theMultiplexes);
    List<Multiplex> DtosToEntities(List<MultiplexDTO> theMultiplexDTOs);

}
