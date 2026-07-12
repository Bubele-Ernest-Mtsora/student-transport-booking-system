package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequestDTO {

    private String bookingDate;

    private Long studentId;

    private Long tripId;

}