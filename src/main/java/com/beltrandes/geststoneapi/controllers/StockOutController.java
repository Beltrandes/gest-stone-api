package com.beltrandes.geststoneapi.controllers;

import com.beltrandes.geststoneapi.dtos.StockOutDTO;
import com.beltrandes.geststoneapi.dtos.WithdrawStockItemQuantityDTO;
import com.beltrandes.geststoneapi.services.StockOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stock/out")
public class StockOutController {
    @Autowired
    private StockOutService stockOutService;

    @GetMapping
    public ResponseEntity<List<StockOutDTO>> getAllStockOuts() {
        return ResponseEntity.ok().body(stockOutService.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> createStockOut(@RequestBody WithdrawStockItemQuantityDTO withdrawStockItemQuantityDTO) {
        stockOutService.create(withdrawStockItemQuantityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
