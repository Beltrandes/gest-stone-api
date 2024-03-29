package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.MaterialDTO;
import com.beltrandes.geststoneapi.dtos.UpdateMaterialPriceDTO;
import com.beltrandes.geststoneapi.models.Material;
import com.beltrandes.geststoneapi.repositories.MaterialRepository;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public MaterialDTO create(MaterialDTO materialDTO) {
        var entity = modelMapper.map(materialDTO, Material.class);
        materialRepository.save(entity);
        return modelMapper.map(entity, MaterialDTO.class);
    }

    public void updateMaterialPrice(UpdateMaterialPriceDTO updateMaterialPriceDTO) {
        var entity = materialRepository.findById(updateMaterialPriceDTO.id()).orElseThrow();
        entity.setLastPrice(updateMaterialPriceDTO.price());
        entity.setPrice(updateMaterialPriceDTO.price());
        entity.setLastPriceUpdate(LocalDateTime.now());
        materialRepository.save(entity);

    }
}
