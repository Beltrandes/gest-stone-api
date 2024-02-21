package com.beltrandes.geststoneapi.controllers;

import com.beltrandes.geststoneapi.dtos.StockDTO;
import com.beltrandes.geststoneapi.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockDTO>> getEmployees() {
        return ResponseEntity.ok(stockService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> getEmployee(@PathVariable @Validated UUID id) {
        return ResponseEntity.ok(stockService.getById(id));
    }
    @PostMapping
    public ResponseEntity<StockDTO> createEmployee(@RequestBody @Validated StockDTO stockDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stockService.create(stockDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockDTO> updateEmployee(@PathVariable @Validated UUID id, @RequestBody @Validated StockDTO stockDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(stockService.update(id, stockDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable @Validated UUID id) {
        stockService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
