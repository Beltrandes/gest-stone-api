package com.beltrandes.geststoneapi.repositories;

import com.beltrandes.geststoneapi.models.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuotationRepository extends JpaRepository<Quotation, UUID> {
}
