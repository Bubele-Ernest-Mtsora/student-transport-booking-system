package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleRequestDTO {

    private Long driverId;

    private String plateNumber;
    private String brand;
    private String model;
    private int capacity;
}