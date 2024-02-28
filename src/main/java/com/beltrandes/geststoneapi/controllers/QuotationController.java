package com.beltrandes.geststoneapi.controllers;

import com.beltrandes.geststoneapi.dtos.QuotationDTO;
import com.beltrandes.geststoneapi.services.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("quotation")
public class QuotationController {
    @Autowired
    private QuotationService quotationService;
    @GetMapping
    public ResponseEntity<List<QuotationDTO>> getAllQuotations() {
        return ResponseEntity.ok().body(quotationService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<QuotationDTO> getQuotationById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(quotationService.getById(id));
    }
}
