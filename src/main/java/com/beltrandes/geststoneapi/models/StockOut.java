package com.beltrandes.geststoneapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "stock_out")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class StockOut {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private StockItem stockItem;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    @JsonBackReference(value = "stockOuts")
    private Stock stock;
    private Integer previousQuantity;
    private Integer withdrawnQuantity;
    @CreationTimestamp
    private LocalDateTime movementDate;


    public StockOut(StockItem stockItem, Employee employee, Stock stock, LocalDateTime movementDate, Integer previousQuantity, Integer withdrawnQuantity) {
        this.stockItem = stockItem;
        this.employee = employee;
        this.stock = stock;
        this.movementDate = movementDate;
        this.previousQuantity = previousQuantity;
        this.withdrawnQuantity = withdrawnQuantity;
    }


}
