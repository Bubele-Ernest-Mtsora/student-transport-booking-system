package com.bubele.studentstransportsystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TripEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    private String departureLocation;
    private String destinationLocation;

    private String departureDate;
    private String departureTime;

    private Double price;

    private int availableSeats;

    private String pickupLocation;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private DriverEntity driver;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;


}

    // Getters and Setters
