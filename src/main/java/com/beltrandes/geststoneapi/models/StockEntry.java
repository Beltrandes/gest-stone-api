package com.beltrandes.geststoneapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "stock_entry")
@EqualsAndHashCode(of = "id")
public class StockEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private StockItem stockItem;
    @ManyToOne
    @JsonIgnore
    private Stock stock;
    @CreationTimestamp
    private LocalDateTime movementDate;
    private Integer previousQuantity;
    private Integer addedQuantity;


    public StockEntry(StockItem stockItem, Stock stock, Integer previousQuantity, Integer addedQuantity) {
        this.stockItem = stockItem;
        this.stock = stock;
        this.previousQuantity = previousQuantity;
        this.addedQuantity = addedQuantity;
    }
}
