package com.bubele.studentstransportsystem.Repository;

import com.bubele.studentstransportsystem.Entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<TripEntity, Long> {
}