package com.beltrandes.geststoneapi.controllers;

import com.beltrandes.geststoneapi.dtos.StockEntryDTO;
import com.beltrandes.geststoneapi.services.StockEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stock/item/entry")
public class StockEntryController {
    @Autowired
    private StockEntryService stockEntryService;

    @GetMapping
    public ResponseEntity<List<StockEntryDTO>> getAllStockEntries() {
        return ResponseEntity.ok().body(stockEntryService.getAll());
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockEntryDTO> createStockEntry(@RequestBody StockEntryDTO stockEntryDTO) {
        return ResponseEntity.ok().body(stockEntryService.create(stockEntryDTO));
    }
}
