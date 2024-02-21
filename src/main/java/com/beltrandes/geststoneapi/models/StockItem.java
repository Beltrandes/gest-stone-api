package com.beltrandes.geststoneapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
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
    private Stock stock;
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
