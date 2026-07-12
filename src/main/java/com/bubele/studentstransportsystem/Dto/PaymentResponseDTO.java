package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponseDTO {

    private Long paymentId;

    private Double amount;

    private String paymentDate;

    private String paymentStatus;

    private Long bookingId;

    // Generate Getters and Setters
}
