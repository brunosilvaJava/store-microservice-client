package com.sales.client.domain.converter;

import java.util.List;

import com.sales.client.dto.ClientDto;
import com.sales.client.domain.model.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto entityToDto(ClientEntity clientEntity);

    List<ClientDto> entitysToDtos(List<ClientEntity> clientEntities);

    ClientEntity dtoToEntity(ClientDto clientDto);

    List<ClientEntity> dtosToEntities(List<ClientDto> clientDtos);

}
