package com.bubele.studentstransportsystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    private String fullName;
    private String licenseNumber;
    private String phoneNumber;
    private String email;
    private String password;

    // New field
    private String driverStatus;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;
}