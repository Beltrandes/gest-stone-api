package com.beltrandes.geststoneapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quote_item")
public class QuoteItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @ManyToOne
    private Quotation quotation;
    @OneToOne
    private Material material;
    private Double measureX;
    private Double measureY;
    private Integer quantity;
    private Double m2;
    private Double totalM2;
    private Double price;
    private Double totalPrice;

    public void calculateM2() {
        m2 = measureX * measureY;
    }
    public void calculateTotalM2() {
        totalM2 = m2 * quantity;
    }
    public void calculatePrice() {
        price = material.getPrice() * m2;
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

    public QuoteItem(String name, Quotation quotation, Material material, Double measureX, Double measureY, Integer quantity) {
        this.name = name;
        this.quotation = quotation;
        this.material = material;
        this.measureX = measureX;
        this.measureY = measureY;
        this.quantity = quantity;
    }


}
