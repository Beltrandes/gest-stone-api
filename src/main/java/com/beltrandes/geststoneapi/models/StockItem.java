package com.beltrandes.geststoneapi.models;

import com.beltrandes.geststoneapi.dtos.StockOutDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference(value = "stockItems")
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
