package com.bubele.studentstransportsystem.Controller;

import com.bubele.studentstransportsystem.Dto.PaymentRequestDTO;
import com.bubele.studentstransportsystem.Dto.PaymentResponseDTO;
import com.bubele.studentstransportsystem.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // CREATE PAYMENT
    @PostMapping
    public PaymentResponseDTO createPayment(@RequestBody PaymentRequestDTO dto) {
        return paymentService.createPayment(dto);
    }

    // GET ALL PAYMENTS
    @GetMapping
    public List<PaymentResponseDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // GET PAYMENT BY ID
    @GetMapping("/{id}")
    public PaymentResponseDTO getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    // DELETE PAYMENT
    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
