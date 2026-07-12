package com.bubele.studentstransportsystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private String plateNumber;
    private String model;
    private String brand;
    private int capacity;

    // getters and setters
}
