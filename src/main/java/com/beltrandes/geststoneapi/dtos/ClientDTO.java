package com.beltrandes.geststoneapi.dtos;

import com.beltrandes.geststoneapi.models.Quotation;
import com.beltrandes.geststoneapi.models.Work;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    UUID id;
    String name;
    String phoneNumber;
    String email;
    String address;
    List<Quotation> quotations;
    List<Work> works;
    LocalDateTime createdAt;
}
