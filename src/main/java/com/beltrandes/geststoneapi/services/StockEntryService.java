package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.StockEntryDTO;
import com.beltrandes.geststoneapi.models.StockEntry;
import com.beltrandes.geststoneapi.repositories.StockEntryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockEntryService {
    @Autowired
    private StockEntryRepository stockEntryRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<StockEntryDTO> getAll() {
        return stockEntryRepository.findAll().stream().map((result) -> modelMapper.map(result, StockEntryDTO.class)).toList();
    }

    public StockEntryDTO create(StockEntryDTO stockEntryDTO) {
        var entity = modelMapper.map(stockEntryDTO, StockEntry.class);
        entity.setPreviousQuantity();
        entity.setStock();
        return modelMapper.map(stockEntryRepository.save(entity), StockEntryDTO.class);
    }

}
