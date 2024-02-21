package com.beltrandes.geststoneapi.repositories;

import com.beltrandes.geststoneapi.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, UUID> {
}
