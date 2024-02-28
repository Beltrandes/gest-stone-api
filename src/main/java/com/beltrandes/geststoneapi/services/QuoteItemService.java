package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.CreateQuoteItemDTO;
import com.beltrandes.geststoneapi.dtos.QuoteItemDTO;
import com.beltrandes.geststoneapi.enums.MaterialType;
import com.beltrandes.geststoneapi.models.Material;
import com.beltrandes.geststoneapi.models.Quotation;
import com.beltrandes.geststoneapi.models.QuoteItem;
import com.beltrandes.geststoneapi.repositories.QuoteItemRepository;
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
            private MaterialService materialService;

    ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public QuoteItemDTO create(CreateQuoteItemDTO createQuoteItemDTO) {
        Quotation quotation = modelMapper.map(quotationService.getById(createQuoteItemDTO.quotationId()), Quotation.class);
        Material material = modelMapper.map(materialService.getById(createQuoteItemDTO.materialId()), Material.class) ;
        if (material == null) {
            throw new IllegalArgumentException("Material does not exist");
        }

        QuoteItem quoteItem = new QuoteItem(
                createQuoteItemDTO.name(),
                createQuoteItemDTO.details(),
                quotation,
                material,
                createQuoteItemDTO.measureX(),
                createQuoteItemDTO.measureY(),
                createQuoteItemDTO.quantity()
        );

        quoteItem.calculateAll();
        quoteItemRepository.save(quoteItem);

        return modelMapper.map(quoteItem, QuoteItemDTO.class);
    }

}
