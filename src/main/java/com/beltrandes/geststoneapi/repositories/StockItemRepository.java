package com.beltrandes.geststoneapi.repositories;

import com.beltrandes.geststoneapi.models.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockItemRepository extends JpaRepository<StockItem, UUID> {
}
