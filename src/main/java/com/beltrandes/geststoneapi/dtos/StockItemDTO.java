package com.beltrandes.geststoneapi.dtos;

import com.beltrandes.geststoneapi.models.Stock;
import com.beltrandes.geststoneapi.models.StockEntry;
import com.beltrandes.geststoneapi.models.StockOut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class StockItemDTO {
    UUID id;
    String name;
    String details;
    StockDTO stock;
    Integer quantity;
    Integer minQuantity;
}
