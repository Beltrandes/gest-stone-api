package com.beltrandes.geststoneapi.controllers;

import com.beltrandes.geststoneapi.dtos.StockItemDTO;
import com.beltrandes.geststoneapi.services.StockItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("stock/item")
public class StockItemController {
    @Autowired
    private StockItemService stockItemService;
    @GetMapping
    public ResponseEntity<List<StockItemDTO>> getAllStockItems() {
        return ResponseEntity.ok().body(stockItemService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StockItemDTO> getStockItem(@PathVariable UUID id) {
        return ResponseEntity.ok().body(stockItemService.getById(id));
    }
    @PostMapping
    public ResponseEntity<StockItemDTO> createStockItem(@RequestBody StockItemDTO stockItemDTO) {
        return ResponseEntity.ok().body(stockItemService.create(stockItemDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<StockItemDTO> updateStockItem(@PathVariable UUID id, @RequestBody StockItemDTO stockItemDTO) {
        return ResponseEntity.ok().body(stockItemService.update(id, stockItemDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockItem(@PathVariable UUID id) {
        stockItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
