package com.beltrandes.geststoneapi.dtos;

import com.beltrandes.geststoneapi.models.Employee;
import com.beltrandes.geststoneapi.models.Stock;
import com.beltrandes.geststoneapi.models.StockItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockOutDTO {
    UUID id;
    StockItem stockItem;
    EmployeeDTO employee;
    Stock stock;
    Integer previousQuantity;
    Integer withdrawnQuantity;
    LocalDateTime movementDate;
}
