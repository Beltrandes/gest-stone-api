package com.beltrandes.geststoneapi.controllers;

import com.beltrandes.geststoneapi.dtos.AddStockItemQuantityDTO;
import com.beltrandes.geststoneapi.dtos.StockEntryDTO;
import com.beltrandes.geststoneapi.services.StockEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stock/entry")
public class StockEntryController {
    @Autowired
    private StockEntryService stockEntryService;

    @GetMapping
    public ResponseEntity<List<StockEntryDTO>> getAllStockEntries() {
        return ResponseEntity.ok().body(stockEntryService.getAll());
    }
    @PostMapping
    public ResponseEntity<String> createStockEntry(@RequestBody AddStockItemQuantityDTO addStockItemQuantityDTO) {
        stockEntryService.create(addStockItemQuantityDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Quantidade adicionada com sucesso, movimento de entrada no estoque criado.");
    }
}
