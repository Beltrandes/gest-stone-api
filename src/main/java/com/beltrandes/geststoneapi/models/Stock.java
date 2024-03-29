package com.beltrandes.geststoneapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "stock", cascade = CascadeType.PERSIST)
    @JsonManagedReference(value = "stockItems")
    private List<StockItem> stockItems = new ArrayList<>();
    @OneToMany(mappedBy = "stock")
    @JsonManagedReference(value = "stockEntries")
    private List<StockEntry> stockEntries = new ArrayList<>();
    @OneToMany(mappedBy = "stock")
    @JsonManagedReference(value = "stockOuts")
    private List<StockOut> stockOuts = new ArrayList<>();
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Stock(String name) {
        this.name = name;
    }

}
