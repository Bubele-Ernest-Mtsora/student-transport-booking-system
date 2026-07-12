package com.bubele.studentstransportsystem. Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDTO {

    private Long bookingId;

    private String bookingDate;

    private String bookingStatus;

    private String studentNumber;

    private String studentName;

    private String destinationLocation;

}