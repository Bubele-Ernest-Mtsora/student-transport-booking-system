package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TripResponseDTO {

    private Long tripId;

    private String departureLocation;
    private String destinationLocation;

    private String departureDate;
    private String departureTime;

    private Double price;

    private int availableSeats;

    private String driverName;
    private String vehiclePlateNumber;

    // Getters and Setters
}
