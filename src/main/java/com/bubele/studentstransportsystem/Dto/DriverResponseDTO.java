package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverResponseDTO {

    private Long driverId;
    private String fullName;
    private String licenseNumber;
    private String phoneNumber;
    private String email;

    // New
    private String driverStatus;

    private String vehiclePlateNumber;
}