package com.beltrandes.geststoneapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock_item")
@EqualsAndHashCode(of = "id")

public class StockItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String details;
    @ManyToOne
    @JsonIgnore
    private Stock stock;
    @OneToMany(mappedBy = "stockItem", cascade = CascadeType.ALL)
    private List<StockEntry> stockEntries = new ArrayList<>();
    @OneToMany(mappedBy = "stockItem", cascade = CascadeType.ALL)
    private List<StockOut> stockOuts = new ArrayList<>();
    private Integer quantity;
    private Integer minQuantity;
    @CreationTimestamp
    private LocalDateTime createdAt;


    public StockItem(String name, String details, Stock stock, Integer quantity, Integer minQuantity) {
        this.name = name;
        this.details = details;
        this.stock = stock;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
    }

    public StockItem(String name, Stock stock, Integer quantity, Integer minQuantity) {
        this.name = name;
        this.stock = stock;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
    }

}
