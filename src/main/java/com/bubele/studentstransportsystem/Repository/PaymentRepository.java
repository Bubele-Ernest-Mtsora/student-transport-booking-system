package com.bubele.studentstransportsystem.Repository;

import com.bubele.studentstransportsystem.Entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository
        extends JpaRepository<PaymentEntity, Long> {
}