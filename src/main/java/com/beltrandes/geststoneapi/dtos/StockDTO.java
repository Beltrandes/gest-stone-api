package com.beltrandes.geststoneapi.dtos;

import com.beltrandes.geststoneapi.models.StockEntry;
import com.beltrandes.geststoneapi.models.StockItem;
import com.beltrandes.geststoneapi.models.StockOut;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class StockDTO {
    UUID id;
    String name;
    @Cascade(value = CascadeType.PERSIST)
    @JsonManagedReference(value = "stockItems")
    List<StockItemDTO> stockItems;
    @JsonBackReference(value = "stockEntries")
    List<StockEntryDTO> stockEntries;
    @JsonBackReference(value = "stockOuts")
    List<StockOutDTO> stockOuts;
}
