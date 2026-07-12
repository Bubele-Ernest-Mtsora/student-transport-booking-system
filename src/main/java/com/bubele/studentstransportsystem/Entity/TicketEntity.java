package com.bubele.studentstransportsystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    private String ticketNumber;

    private String issueDate;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;

    // Generate Getters and Setters
}