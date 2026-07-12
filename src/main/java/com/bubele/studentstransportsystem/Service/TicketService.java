package com.bubele.studentstransportsystem.Service;


import com.bubele.studentstransportsystem.Dto.TicketResponseDTO;
import com.bubele.studentstransportsystem.Entity.TicketEntity;
import com.bubele.studentstransportsystem.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<TicketResponseDTO> getAllTickets() {

        return ticketRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public TicketResponseDTO getTicketById(Long id) {

        TicketEntity ticket = ticketRepository.findById(id).orElse(null);

        return ticket != null ? mapToResponse(ticket) : null;
    }

    private TicketResponseDTO mapToResponse(TicketEntity ticket) {

        TicketResponseDTO dto = new TicketResponseDTO();

        dto.setTicketId(ticket.getTicketId());
        dto.setTicketNumber(ticket.getTicketNumber());
        dto.setIssueDate(ticket.getIssueDate());

        dto.setStudentName(
                ticket.getBooking()
                        .getStudent()
                        .getFirstName() + " " +
                        ticket.getBooking()
                                .getStudent()
                                .getLastName());

        dto.setStudentNumber(
                ticket.getBooking()
                        .getStudent()
                        .getStudentNumber());

        dto.setPickupLocation(
                ticket.getBooking()
                        .getTrip()
                        .getPickupLocation());

        dto.setDestinationLocation(
                ticket.getBooking()
                        .getTrip()
                        .getDestinationLocation());

        dto.setDepartureDate(
                ticket.getBooking()
                        .getTrip()
                        .getDepartureDate());

        dto.setDepartureTime(
                ticket.getBooking()
                        .getTrip()
                        .getDepartureTime());

        dto.setDriverName(
                ticket.getBooking()
                        .getTrip()
                        .getDriver()
                        .getFullName());

        dto.setVehiclePlateNumber(
                ticket.getBooking()
                        .getTrip()
                        .getVehicle()
                        .getPlateNumber());

        return dto;
    }
}
