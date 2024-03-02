package com.beltrandes.geststoneapi.dtos;

import java.util.UUID;

public record UpdateMaterialPriceDTO(
        UUID id,
        Double price
) {
}
