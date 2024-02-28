package com.beltrandes.geststoneapi.dtos;

import com.beltrandes.geststoneapi.models.Client;
import com.beltrandes.geststoneapi.models.QuoteItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuotationDTO {
    UUID id;
    String name;
    String details;
    Client client;
    List<QuoteItem> quoteItems;
    Double totalPrice;
    Double totalM2;
    Integer deadlineDays;
    LocalDateTime expiration;
    LocalDateTime createdAt;
}
