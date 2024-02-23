package com.beltrandes.geststoneapi.dtos;

import java.util.UUID;

public record AddStockItemQuantityDTO(
        UUID stockItemId,
        Integer quantity
) {
}
