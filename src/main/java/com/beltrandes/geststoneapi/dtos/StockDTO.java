package com.beltrandes.geststoneapi.dtos;

import com.beltrandes.geststoneapi.models.StockEntry;
import com.beltrandes.geststoneapi.models.StockItem;
import com.beltrandes.geststoneapi.models.StockOut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class StockDTO {
    UUID id;
    String name;
    List<StockItem> stockItems;
    List<StockEntry> stockEntries;
    List<StockOut> stockOuts;
}
