package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TripRequestDTO {

    private String departureLocation;
    private String destinationLocation;

    private String departureDate;
    private String departureTime;

    private Double price;

    private int availableSeats;

    private Long driverId;
    private Long vehicleId;

    // Getters and Setters
}
