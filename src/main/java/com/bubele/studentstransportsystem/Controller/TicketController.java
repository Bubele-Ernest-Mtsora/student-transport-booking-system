package com.bubele.studentstransportsystem.Controller;


import com.bubele.studentstransportsystem.Dto.TicketResponseDTO;
import com.bubele.studentstransportsystem.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // GET ALL TICKETS
    @GetMapping
    public List<TicketResponseDTO> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // GET TICKET BY ID
    @GetMapping("/{id}")
    public TicketResponseDTO getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

}