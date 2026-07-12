package com.bubele.studentstransportsystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Double amount;

    private String paymentDate;

    private String paymentStatus;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;

}