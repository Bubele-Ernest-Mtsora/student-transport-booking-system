package com.bubele.studentstransportsystem.Repository;



import com.bubele.studentstransportsystem.Entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}
