package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleResponseDTO {

    private Long vehicleId;

    private String plateNumber;
    private String brand;
    private String model;
    private int capacity;
}