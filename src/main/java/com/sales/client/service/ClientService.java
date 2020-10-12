package com.sales.client.service;

import java.util.List;

import com.sales.client.domain.converter.ClientMapper;
import com.sales.client.dto.ClientDto;
import com.sales.client.domain.model.ClientEntity;
import com.sales.client.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void save(ClientDto clientDto){
        clientRepository.save(ClientMapper.INSTANCE.dtoToEntity(clientDto));
    }

    @Transactional
    public void update(ClientDto clientDto){
        ClientEntity clientTransaction = findClientEntityById(clientDto.getId());
        clientTransaction.setName(clientDto.getName());
    }

    @Transactional
    public void delete(Long clientId){
        clientRepository.deleteById(clientId);
    }

    public List<ClientDto> findAll(){
        return ClientMapper.INSTANCE.entitysToDtos(clientRepository.findAll());
    }

    public ClientDto findByClientId(final Long clientId){
        ClientEntity clientEntity = clientRepository.findById(clientId).orElseThrow(RuntimeException::new); // TODO CRIAR CLIENT NOT FOUND EXCEPTION
        return ClientMapper.INSTANCE.entityToDto(clientEntity);
    }

    private ClientEntity findClientEntityById (final Long clientId) {
        return clientRepository.findById(clientId).orElseThrow(RuntimeException::new);
    }

}
