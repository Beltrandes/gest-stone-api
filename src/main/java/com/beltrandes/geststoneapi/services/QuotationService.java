package com.beltrandes.geststoneapi.services;

import com.beltrandes.geststoneapi.dtos.QuotationDTO;
import com.beltrandes.geststoneapi.models.Quotation;
import com.beltrandes.geststoneapi.models.QuoteItem;
import com.beltrandes.geststoneapi.repositories.QuotationRepository;
import com.beltrandes.geststoneapi.repositories.QuoteItemRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QuotationService {
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    QuoteItemRepository quoteItemRepository;
    @Autowired
    private QuotationRepository quotationRepository;

    public List<QuotationDTO> getAll() {
        return quotationRepository.findAll().stream().map((result) -> modelMapper.map(result, QuotationDTO.class)).toList();
    }

    public QuotationDTO getById(UUID id) {
        return modelMapper.map(quotationRepository.findById(id).orElseThrow(), QuotationDTO.class);

    }
    @Transactional
    public void updateQuoteItems(UUID id, QuoteItem quoteItem) {
        var quotation = quotationRepository.findById(id).orElseThrow();
        quoteItemRepository.save(quoteItem);
        quotation.getQuoteItems().add(quoteItem);
        quotation.calculateTotalM2();
        quotation.calculateTotalPrice();
        quotationRepository.save(quotation);
    }
}
