package com.beltrandes.geststoneapi.models;

import com.beltrandes.geststoneapi.enums.EmployeeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String documentNumber;
    private EmployeeRole employeeRole;

    public Employee(String name, String documentNumber, EmployeeRole employeeRole) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.employeeRole = employeeRole;
    }

}
