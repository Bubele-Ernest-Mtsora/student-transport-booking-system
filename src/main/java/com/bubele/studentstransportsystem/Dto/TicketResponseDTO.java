package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResponseDTO {

    private Long ticketId;

    private String ticketNumber;

    private String issueDate;

    private String studentName;

    private String studentNumber;

    private String pickupLocation;

    private String destinationLocation;

    private String departureDate;

    private String departureTime;

    private String driverName;

    private String vehiclePlateNumber;

    // Generate Getters and Setters
}
