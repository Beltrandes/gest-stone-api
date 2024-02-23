package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.AddStockItemQuantityDTO;
import com.beltrandes.geststoneapi.dtos.StockEntryDTO;
import com.beltrandes.geststoneapi.models.StockEntry;
import com.beltrandes.geststoneapi.models.StockItem;
import com.beltrandes.geststoneapi.repositories.StockEntryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockEntryService {
    @Autowired
    private StockEntryRepository stockEntryRepository;

    @Autowired
    private StockItemService stockItemService;
    ModelMapper modelMapper = new ModelMapper();

    public List<StockEntryDTO> getAll() {
        return stockEntryRepository.findAll().stream().map((result) -> modelMapper.map(result, StockEntryDTO.class)).toList();
    }

    public void create(AddStockItemQuantityDTO addStockItemQuantityDTO) {
        var stockItem = modelMapper.map(stockItemService.getById(addStockItemQuantityDTO.stockItemId()), StockItem.class);
        if (stockItem != null) {
            var stockEntry = new StockEntry();
            stockEntry.setPreviousQuantity(stockItem.getQuantity());
            stockEntry.setAddedQuantity(addStockItemQuantityDTO.quantity());
            stockItemService.addStockItemQuantity(stockItem, addStockItemQuantityDTO.quantity());
            stockEntry.setStockItem(stockItem);
            stockEntry.setStock(stockItem.getStock());
            stockEntryRepository.save(stockEntry);
        }
    }

}
