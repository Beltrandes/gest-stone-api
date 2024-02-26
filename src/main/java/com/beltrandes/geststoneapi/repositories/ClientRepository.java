package com.beltrandes.geststoneapi.repositories;

import com.beltrandes.geststoneapi.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
