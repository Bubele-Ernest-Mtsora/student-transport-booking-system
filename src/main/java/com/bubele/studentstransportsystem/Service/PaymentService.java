package com.bubele.studentstransportsystem.Service;

import com.bubele.studentstransportsystem.Dto.PaymentRequestDTO;
import com.bubele.studentstransportsystem.Dto.PaymentResponseDTO;
import com.bubele.studentstransportsystem.Entity.BookingEntity;
import com.bubele.studentstransportsystem.Entity.PaymentEntity;
import com.bubele.studentstransportsystem.Repository.BookingRepository;
import com.bubele.studentstransportsystem.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // CREATE PAYMENT
    public PaymentResponseDTO createPayment(PaymentRequestDTO dto) {

        BookingEntity booking =
                bookingRepository.findById(dto.getBookingId()).orElse(null);

        if (booking == null) {
            return null;
        }

        PaymentEntity payment = new PaymentEntity();

        payment.setPaymentDate(dto.getPaymentDate());

        // Get amount from the Trip
        payment.setAmount(
                booking.getTrip().getPrice()
        );

        payment.setPaymentStatus("PAID");

        payment.setBooking(booking);

        // Update booking status
        booking.setBookingStatus("APPROVED");
        bookingRepository.save(booking);

        PaymentEntity saved =
                paymentRepository.save(payment);

        return mapToResponse(saved);
    }

    // GET ALL PAYMENTS
    public List<PaymentResponseDTO> getAllPayments() {

        return paymentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // GET PAYMENT BY ID
    public PaymentResponseDTO getPaymentById(Long id) {

        PaymentEntity payment =
                paymentRepository.findById(id).orElse(null);

        return payment != null
                ? mapToResponse(payment)
                : null;
    }

    // DELETE PAYMENT
    public void deletePayment(Long id) {

        paymentRepository.deleteById(id);
    }

    // DTO Mapping
    private PaymentResponseDTO mapToResponse(PaymentEntity payment) {

        PaymentResponseDTO dto =
                new PaymentResponseDTO();

        dto.setPaymentId(payment.getPaymentId());
        dto.setAmount(payment.getAmount());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setPaymentStatus(payment.getPaymentStatus());
        dto.setBookingId(
                payment.getBooking().getBookingId()
        );

        return dto;
    }
}