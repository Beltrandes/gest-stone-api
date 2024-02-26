package com.beltrandes.geststoneapi.repositories;

import com.beltrandes.geststoneapi.models.QuoteItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuoteItemRepository extends JpaRepository<QuoteItem, UUID> {
}
