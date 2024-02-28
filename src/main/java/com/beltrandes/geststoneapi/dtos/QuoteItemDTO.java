package com.beltrandes.geststoneapi.dtos;

import com.beltrandes.geststoneapi.models.Material;
import com.beltrandes.geststoneapi.models.Quotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteItemDTO {
    UUID id;
    String name;
    String details;
    Quotation quotation;
    Material material;
    Double measureX;
    Double measureY;
    Integer quantity;
    Double m2;
    Double totalM2;
    Double price;
    Double totalPrice;
}
