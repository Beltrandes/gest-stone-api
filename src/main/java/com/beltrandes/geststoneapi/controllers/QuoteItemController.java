package com.beltrandes.geststoneapi.controllers;

import com.beltrandes.geststoneapi.dtos.CreateQuoteItemDTO;
import com.beltrandes.geststoneapi.dtos.QuoteItemDTO;
import com.beltrandes.geststoneapi.services.QuoteItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quotation/item")
public class QuoteItemController {
    @Autowired
    private QuoteItemService quoteItemService;
    @PostMapping("/create")
    @Transactional
    public ResponseEntity<QuoteItemDTO> create(@RequestBody CreateQuoteItemDTO createQuoteItemDTO) {
        return ResponseEntity.ok().body(quoteItemService.create(createQuoteItemDTO));
    }
}
