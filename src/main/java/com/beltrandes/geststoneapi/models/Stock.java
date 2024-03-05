package com.beltrandes.geststoneapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StockItem> stockItems = new ArrayList<>();
    @OneToMany(mappedBy = "stock" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StockEntry> stockEntries = new ArrayList<>();
    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StockOut> stockOuts = new ArrayList<>();
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Stock(String name) {
        this.name = name;
    }

}
