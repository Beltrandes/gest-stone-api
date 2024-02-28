package com.beltrandes.geststoneapi.models;

import com.beltrandes.geststoneapi.enums.WorkStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @ManyToOne
    @JsonIgnore
    private Client client;
    private String address;
    private WorkStatus status;
    private LocalDateTime deadline;
    private LocalDateTime endDate;

}
