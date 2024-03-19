package com.beltrandes.geststoneapi.dtos;

import com.beltrandes.geststoneapi.models.Stock;
import com.beltrandes.geststoneapi.models.StockItem;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class StockEntryDTO {
    UUID id;
    StockItemDTO stockItem;
    @JsonBackReference(value = "stockEntries")
    StockDTO stock;
    Integer previousQuantity;
    Integer addedQuantity;
    LocalDateTime movementDate;
}
