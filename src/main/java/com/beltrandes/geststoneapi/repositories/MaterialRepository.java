package com.beltrandes.geststoneapi.repositories;

import com.beltrandes.geststoneapi.models.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MaterialRepository extends JpaRepository<Material, UUID> {
}
