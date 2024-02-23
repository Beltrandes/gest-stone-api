package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.EmployeeDTO;
import com.beltrandes.geststoneapi.dtos.StockDTO;
import com.beltrandes.geststoneapi.dtos.StockItemDTO;
import com.beltrandes.geststoneapi.models.Stock;
import com.beltrandes.geststoneapi.models.StockItem;
import com.beltrandes.geststoneapi.repositories.StockItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StockItemService {
    @Autowired
    private StockItemRepository stockItemRepository;
    ModelMapper modelMapper = new ModelMapper();

    public List<StockItemDTO> getAll() {
        return stockItemRepository.findAll().stream().map((result) -> modelMapper.map(result, StockItemDTO.class)).toList();
    }

    public StockItemDTO getById(UUID id) {
        var entity = stockItemRepository.findById(id).orElseThrow();
        return modelMapper.map(entity, StockItemDTO.class);
    }

    public StockItemDTO create(StockItemDTO stockItemDTO) {
        var entity = modelMapper.map(stockItemDTO, StockItem.class);
        stockItemRepository.save(entity);
        return modelMapper.map(entity, StockItemDTO.class);

    }

    public StockItemDTO update(UUID id, StockItemDTO stockItemDTO) {
        var entity = stockItemRepository.findById(id).orElseThrow();
        entity.setName(stockItemDTO.getName());
        entity.setDetails(stockItemDTO.getDetails());
        entity.setMinQuantity(stockItemDTO.getMinQuantity());
        entity.setQuantity(stockItemDTO.getQuantity());
        stockItemRepository.save(entity);
        return modelMapper.map(entity, StockItemDTO.class);
    }

    public void delete(UUID id) {
        var entity = stockItemRepository.findById(id).orElseThrow();
        stockItemRepository.delete(entity);
    }

    public void addStockItemQuantity(StockItem stockItem, int quantity) {
        if (stockItem != null) {
            stockItem.setQuantity(stockItem.getQuantity() + quantity);
            stockItemRepository.save(stockItem);
        }
    }

    public void withdrawStockItemQuantity(StockItem stockItem, int quantity) {
        if (stockItem != null) {
            if (stockItem.getQuantity() >= quantity) {
                stockItem.setQuantity(stockItem.getQuantity() - quantity);
                stockItemRepository.save(stockItem);
            }
        }
    }
}
