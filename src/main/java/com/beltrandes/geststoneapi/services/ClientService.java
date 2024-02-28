package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.ClientDTO;
import com.beltrandes.geststoneapi.models.Client;
import com.beltrandes.geststoneapi.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<ClientDTO> getAll() {
        return clientRepository.findAll().stream().map((result) -> modelMapper.map(result, ClientDTO.class)).toList();
    }

    public ClientDTO getById(UUID id) {
        var entity = clientRepository.findById(id).orElseThrow();
        return modelMapper.map(entity, ClientDTO.class);
    }

    public ClientDTO create(ClientDTO clientDTO) {
        var entity = modelMapper.map(clientDTO, Client.class);
        clientRepository.save(entity);
        return modelMapper.map(entity, ClientDTO.class);
    }

    public ClientDTO update(UUID id, ClientDTO clientDTO) {
        var entity = clientRepository.findById(id).orElseThrow();
        entity.setName(clientDTO.getName());
        entity.setPhoneNumber(clientDTO.getPhoneNumber());
        entity.setAddress(clientDTO.getAddress());
        entity.setEmail(clientDTO.getEmail());
        clientRepository.save(entity);
        return modelMapper.map(entity, ClientDTO.class);
    }

    public void delete(UUID id) {
        var entity = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(entity);
    }
}
