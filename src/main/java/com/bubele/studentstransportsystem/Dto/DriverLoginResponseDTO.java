package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverLoginResponseDTO {

    private Long driverId;
    private String fullName;
    private String email;
    private String driverStatus;
    private String message;

}