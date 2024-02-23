package com.beltrandes.geststoneapi.dtos;

import java.util.UUID;

public record WithdrawStockItemQuantityDTO(
        UUID employeeId,
        UUID stockItemId,
        Integer quantity
) {
}
