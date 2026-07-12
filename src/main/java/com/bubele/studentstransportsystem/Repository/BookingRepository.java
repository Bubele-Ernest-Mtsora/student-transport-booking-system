package com.bubele.studentstransportsystem.Repository;

import com.bubele.studentstransportsystem.Entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
}