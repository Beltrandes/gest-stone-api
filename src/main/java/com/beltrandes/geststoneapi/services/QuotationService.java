package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.QuotationDTO;
import com.beltrandes.geststoneapi.repositories.QuotationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QuotationService {
    @Autowired
    private QuotationRepository quotationRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<QuotationDTO> getAll() {
        return quotationRepository.findAll().stream().map((result) -> modelMapper.map(result, QuotationDTO.class)).toList();
    }

    public QuotationDTO getById(UUID id) {
        return modelMapper.map(quotationRepository.findById(id).orElseThrow(), QuotationDTO.class);

    }
}
