package com.bubele.studentstransportsystem.Service;

import com.bubele.studentstransportsystem.Dto.BookingRequestDTO;
import com.bubele.studentstransportsystem.Dto.BookingResponseDTO;
import com.bubele.studentstransportsystem.Entity.BookingEntity;
import com.bubele.studentstransportsystem.Entity.StudentEntity;
import com.bubele.studentstransportsystem.Entity.TripEntity;
import com.bubele.studentstransportsystem.Repository.BookingRepository;
import com.bubele.studentstransportsystem.Repository.StudentRepository;
import com.bubele.studentstransportsystem.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TripRepository tripRepository;

    // CREATE BOOKING
    public BookingResponseDTO createBooking(BookingRequestDTO dto) {

        StudentEntity student =
                studentRepository.findById(dto.getStudentId()).orElse(null);

        TripEntity trip =
                tripRepository.findById(dto.getTripId()).orElse(null);

        if (student == null || trip == null) {
            return null;
        }

        // Check available seats
        if (trip.getAvailableSeats() <= 0) {
            return null;
        }

        BookingEntity booking = new BookingEntity();

        booking.setBookingDate(dto.getBookingDate());

        // System controls status
        booking.setBookingStatus("IN PROCESS");

        booking.setStudent(student);
        booking.setTrip(trip);

        // Reduce seats
        trip.setAvailableSeats(
                trip.getAvailableSeats() - 1
        );

        tripRepository.save(trip);

        BookingEntity saved =
                bookingRepository.save(booking);

        return mapToResponse(saved);
    }

    // GET ALL BOOKINGS
    public List<BookingResponseDTO> getAllBookings() {

        return bookingRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // GET BOOKING BY ID
    public BookingResponseDTO getBookingById(Long id) {

        BookingEntity booking =
                bookingRepository.findById(id).orElse(null);

        return booking != null
                ? mapToResponse(booking)
                : null;
    }

    // UPDATE BOOKING
    public BookingResponseDTO updateBooking(
            Long id,
            BookingRequestDTO dto) {

        BookingEntity booking =
                bookingRepository.findById(id).orElse(null);

        if (booking == null) {
            return null;
        }

        StudentEntity student =
                studentRepository.findById(dto.getStudentId()).orElse(null);

        TripEntity trip =
                tripRepository.findById(dto.getTripId()).orElse(null);

        if (student == null || trip == null) {
            return null;
        }

        booking.setBookingDate(dto.getBookingDate());
        booking.setStudent(student);
        booking.setTrip(trip);

        BookingEntity updated =
                bookingRepository.save(booking);

        return mapToResponse(updated);
    }

    // DELETE BOOKING
    public void deleteBooking(Long id) {

        BookingEntity booking =
                bookingRepository.findById(id).orElse(null);

        if (booking != null) {

            TripEntity trip = booking.getTrip();

            // Return seat
            trip.setAvailableSeats(
                    trip.getAvailableSeats() + 1
            );

            tripRepository.save(trip);

            bookingRepository.deleteById(id);
        }
    }

    // DTO Mapping
    private BookingResponseDTO mapToResponse(
            BookingEntity booking) {

        BookingResponseDTO dto =
                new BookingResponseDTO();

        dto.setBookingId(booking.getBookingId());
        dto.setBookingDate(booking.getBookingDate());
        dto.setBookingStatus(booking.getBookingStatus());

        dto.setStudentNumber(
                booking.getStudent().getStudentNumber()
        );

        dto.setStudentName(
                booking.getStudent().getFirstName()
                        + " "
                        + booking.getStudent().getLastName()
        );

        dto.setDestinationLocation(
                booking.getTrip().getDestinationLocation()
        );

        return dto;
    }
}