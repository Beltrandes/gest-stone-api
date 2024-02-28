package com.beltrandes.geststoneapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Quotation> quotations = new ArrayList<>();
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Work> works = new ArrayList<>();
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Client(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}
