package com.bubele.studentstransportsystem.Controller;

import com.bubele.studentstransportsystem.Dto.BookingRequestDTO;
import com.bubele.studentstransportsystem.Dto.BookingResponseDTO;
import com.bubele.studentstransportsystem.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // CREATE BOOKING
    @PostMapping
    public BookingResponseDTO createBooking(
            @RequestBody BookingRequestDTO dto) {

        return bookingService.createBooking(dto);
    }

    // GET ALL BOOKINGS
    @GetMapping("all")
    public List<BookingResponseDTO> getAllBookings() {

        return bookingService.getAllBookings();
    }

    // GET BOOKING BY ID
    @GetMapping("/{id}")
    public BookingResponseDTO getBookingById(
            @PathVariable Long id) {

        return bookingService.getBookingById(id);
    }

    // UPDATE BOOKING
    @PutMapping("/{id}")
    public BookingResponseDTO updateBooking(
            @PathVariable Long id,
            @RequestBody BookingRequestDTO dto) {

        return bookingService.updateBooking(id, dto);
    }

    // DELETE BOOKING
    @DeleteMapping("/{id}")
    public void deleteBooking(
            @PathVariable Long id) {

        bookingService.deleteBooking(id);
    }
}
