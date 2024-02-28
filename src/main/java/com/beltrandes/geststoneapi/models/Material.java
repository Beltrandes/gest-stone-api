package com.beltrandes.geststoneapi.models;

import com.beltrandes.geststoneapi.enums.MaterialType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Transactional
@EqualsAndHashCode(of = "id")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Double price;
    private String primaryColor;
    private String secondaryColor;
    private boolean isMottled;
    private boolean hasSpots;
    private boolean hasCrystals;
    private MaterialType type;
    @OneToMany(mappedBy = "material")
    private List<QuoteItem> items = new ArrayList<>();


    public Material(String name, Double price, String primaryColor, String secondaryColor, boolean isMottled, boolean hasSpots, boolean hasCrystals, MaterialType type) {
        this.name = name;
        this.price = price;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.isMottled = isMottled;
        this.hasSpots = hasSpots;
        this.hasCrystals = hasCrystals;
        this.type = type;
    }
}
