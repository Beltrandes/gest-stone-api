package com.beltrandes.geststoneapi.repositories;

import com.beltrandes.geststoneapi.models.StockOut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockOutRepository extends JpaRepository<StockOut, UUID> {
}
