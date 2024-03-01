package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.CreateQuoteItemDTO;
import com.beltrandes.geststoneapi.dtos.QuoteItemDTO;
import com.beltrandes.geststoneapi.enums.MaterialType;
import com.beltrandes.geststoneapi.models.*;
import com.beltrandes.geststoneapi.repositories.MaterialRepository;
import com.beltrandes.geststoneapi.repositories.QuoteItemRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.util.Optional;

@Service
public class QuoteItemService {
    @Autowired
    private QuoteItemRepository quoteItemRepository;
    @Autowired
    private QuotationService quotationService;
    @Autowired
    private MaterialRepository materialRepository;

    ModelMapper modelMapper = new ModelMapper();
    @Transactional
    public void create(CreateQuoteItemDTO createQuoteItemDTO) {
        var quotation = modelMapper.map(quotationService.getById(createQuoteItemDTO.quotationId()), Quotation.class);
        var material = materialRepository.findById(createQuoteItemDTO.materialId()).orElseThrow(() -> new EntityNotFoundException("Material not foud"));
        if (quotation != null) {
            var quoteItem = new QuoteItem();
            quoteItem.setQuotation(quotation);
            if (material != null) {
                quoteItem.setMaterial(material);
                quoteItem.setQuantity(createQuoteItemDTO.quantity());
                quoteItem.setMeasureY(createQuoteItemDTO.measureY());
                quoteItem.setMeasureX(createQuoteItemDTO.measureX());
                quoteItem.setName(createQuoteItemDTO.name());
                quoteItem.setDetails(createQuoteItemDTO.details());
                quoteItem.calculateM2();
                quoteItem.calculateTotalM2();
                quoteItem.calculatePrice();
                quoteItem.calculateTotalPrice();
                quotationService.updateQuoteItems(createQuoteItemDTO.quotationId(), quoteItem);
            }
        }
    }

}
