package com.beltrandes.geststoneapi.models;

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
    @OneToMany(mappedBy = "stock")
    @Setter(value = AccessLevel.NONE)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<StockItem> stockItems = new ArrayList<>();
    @OneToMany(mappedBy = "stock")
    @Setter(value = AccessLevel.NONE)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<StockEntry> stockEntries = new ArrayList<>();
    @OneToMany(mappedBy = "stock")
    @Setter(value = AccessLevel.NONE)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<StockOut> stockOuts = new ArrayList<>();
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Stock(String name) {
        this.name = name;
    }

}
