package com.beltrandes.geststoneapi.repositories;

import com.beltrandes.geststoneapi.models.StockEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockEntryRepository extends JpaRepository<StockEntry, UUID> {
}
