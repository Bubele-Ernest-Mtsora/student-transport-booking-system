package com.bubele.studentstransportsystem.Repository;

import com.bubele.studentstransportsystem.Entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    Optional<VehicleEntity> findByPlateNumber(String plateNumber);

}