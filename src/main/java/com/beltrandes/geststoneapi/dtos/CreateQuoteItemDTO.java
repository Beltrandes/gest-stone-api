package com.beltrandes.geststoneapi.dtos;

import java.util.UUID;

public record CreateQuoteItemDTO(
            String name,
            String details,
            UUID quotationId,
            UUID materialId,
            Double measureX,
            Double measureY,
            Integer quantity

) {
}
