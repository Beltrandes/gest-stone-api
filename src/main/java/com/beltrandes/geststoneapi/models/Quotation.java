package com.beltrandes.geststoneapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String details;
    @ManyToOne
    @JsonIgnore
    private Client client;
    @OneToMany(mappedBy = "quotation")
    @Setter(value = AccessLevel.NONE)
    @JsonIgnore
    private List<QuoteItem> quoteItems = new ArrayList<>();
    private Double totalPrice;
    private Double totalM2;
    private Integer deadlineDays;
    private LocalDateTime expiration;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Quotation(Client client, Integer deadlineDays, LocalDateTime expiration) {
        this.client = client;
        this.deadlineDays = deadlineDays;
        this.expiration = expiration;
    }

    public Quotation(String name, String details, Client client, Integer deadlineDays, LocalDateTime expiration) {
        this.name = name;
        this.details = details;
        this.client = client;
        this.deadlineDays = deadlineDays;
        this.expiration = expiration;
    }

    public void calculateTotalM2() {
        if (quoteItems != null && !quoteItems.isEmpty()) {
            this.totalM2 = quoteItems.stream().mapToDouble(QuoteItem::getTotalM2).sum();
        } else {
            totalPrice = 0.0;
        }

    }

    public void calculateTotalPrice() {
        if (quoteItems != null && !quoteItems.isEmpty()) {
            this.totalPrice = quoteItems.stream().mapToDouble(QuoteItem::getTotalPrice).sum();
        } else {
            totalPrice = 0.0;
        }

    }

}
