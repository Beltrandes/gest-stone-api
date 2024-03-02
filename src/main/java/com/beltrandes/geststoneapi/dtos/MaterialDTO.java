package com.beltrandes.geststoneapi.dtos;

import com.beltrandes.geststoneapi.enums.MaterialType;
import com.beltrandes.geststoneapi.models.Material;
import com.beltrandes.geststoneapi.models.QuoteItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {
    UUID id;
    String name;
    Double price;
    Double lastPrice;
    LocalDateTime lastUpdatePrice;
    String primaryColor;
    String secondaryColor;
    boolean isMottled;
    boolean hasSpots;
    boolean hasCrystals;
    MaterialType type;
    List<QuoteItem> items;

}
