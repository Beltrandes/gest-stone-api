package com.beltrandes.geststoneapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "quote_item")
public class QuoteItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String details;
    @ManyToOne
    @JsonIgnore
    private Quotation quotation;
    @ManyToOne
    @JsonIgnore
    private Material material;
    private Double measureX;
    private Double measureY;
    private Integer quantity;
    private Double m2;
    private Double totalM2;
    private Double price;
    private Double totalPrice;

    public QuoteItem(String name, String details, Quotation quotation, Material material, Double measureX, Double measureY, Integer quantity) {
        this.name = name;
        this.details = details;
        this.quotation = quotation;
        this.material = material;
        this.measureX = measureX;
        this.measureY = measureY;
        this.quantity = quantity;
    }

    public void calculateM2() {
        m2 = measureX * measureY;
    }

    public void calculateTotalM2() {
        totalM2 = m2 * quantity;
    }

    public void calculatePrice() {
        if (material != null) {
            price = material.getPrice() * m2;

        }
    }

    public void calculateTotalPrice() {
        totalPrice = price * quantity;
    }

    public void calculateAll() {
        calculateM2();
        calculateTotalM2();
        calculatePrice();
        calculateTotalPrice();
    }


}
