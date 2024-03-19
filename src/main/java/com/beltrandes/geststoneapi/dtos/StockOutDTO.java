package com.beltrandes.geststoneapi.dtos;

import com.beltrandes.geststoneapi.models.Employee;
import com.beltrandes.geststoneapi.models.Stock;
import com.beltrandes.geststoneapi.models.StockItem;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class StockOutDTO {
    UUID id;
    StockItemDTO stockItem;
    EmployeeDTO employee;
    @JsonBackReference(value = "stockOuts")
    StockDTO stock;
    Integer previousQuantity;
    Integer withdrawnQuantity;
    LocalDateTime movementDate;
}
