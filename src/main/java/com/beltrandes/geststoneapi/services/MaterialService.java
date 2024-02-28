package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.MaterialDTO;
import com.beltrandes.geststoneapi.repositories.MaterialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;
    ModelMapper modelMapper = new ModelMapper();

    public List<MaterialDTO> getAll() {
        return materialRepository.findAll().stream().map((result) -> modelMapper.map(result, MaterialDTO.class)).toList();
    }
    public MaterialDTO getById(UUID id) {
        return modelMapper.map(materialRepository.findById(id).orElseThrow(), MaterialDTO.class);
    }
}
