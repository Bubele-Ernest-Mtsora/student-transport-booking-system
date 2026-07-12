package com.bubele.studentstransportsystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDTO {

    private Double amount;

    private String paymentDate;

    private Long bookingId;

    // Generate Getters and Setters
}
