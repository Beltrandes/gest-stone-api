package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.StockDTO;
import com.beltrandes.geststoneapi.dtos.StockItemDTO;
import com.beltrandes.geststoneapi.models.Stock;
import com.beltrandes.geststoneapi.models.StockItem;
import com.beltrandes.geststoneapi.repositories.StockItemRepository;
import com.beltrandes.geststoneapi.repositories.StockRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockItemService stockItemService;
    ModelMapper modelMapper = new ModelMapper();

    public List<StockDTO> getAll() {
        return stockRepository.findAll().stream().map((result) -> modelMapper.map(result, StockDTO.class)).toList();
    }

    public StockDTO getById(UUID id) {
        var entity = stockRepository.findById(id).orElseThrow();
        return modelMapper.map(entity, StockDTO.class);
    }

    public StockDTO create(StockDTO stockDTO) {
        var entity = modelMapper.map(stockDTO, Stock.class);
        stockRepository.save(entity);
        return modelMapper.map(entity, StockDTO.class);

    }

    public StockDTO update(UUID id, StockDTO stockDTO) {
        var entity = stockRepository.findById(id).orElseThrow();
        entity.setName(stockDTO.getName());
        stockRepository.save(entity);
        return modelMapper.map(entity, StockDTO.class);
    }

    public void delete(UUID id) {
        var entity = stockRepository.findById(id).orElseThrow();
        stockRepository.delete(entity);
    }
}
