package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDTO {

    private Long vehicleId;
    private String plateNumber;
    private String model;
    private String brand;
    private int capacity;

    // getters and setters
}