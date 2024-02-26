package com.beltrandes.geststoneapi.repositories;

import com.beltrandes.geststoneapi.models.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkRepository extends JpaRepository<Work, UUID> {
}
