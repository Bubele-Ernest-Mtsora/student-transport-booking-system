package com.bubele.studentstransportsystem.Service;

import com.bubele.studentstransportsystem.Dto.VehicleRequestDTO;
import com.bubele.studentstransportsystem.Dto.VehicleResponseDTO;
import com.bubele.studentstransportsystem.Entity.DriverEntity;
import com.bubele.studentstransportsystem.Entity.VehicleEntity;
import com.bubele.studentstransportsystem.Repository.DriverRepository;
import com.bubele.studentstransportsystem.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private DriverRepository driverRepository;

    // ===========================
    // REGISTER VEHICLE
    // ===========================
    public VehicleResponseDTO createVehicle(VehicleRequestDTO dto) {

        DriverEntity driver = driverRepository.findById(dto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Driver not found."));

        // One driver = One vehicle
        if (driver.getVehicle() != null) {
            throw new RuntimeException("This driver has already registered a vehicle.");
        }

        // One plate number = One vehicle
        if (vehicleRepository.findByPlateNumber(dto.getPlateNumber()).isPresent()) {
            throw new RuntimeException("Vehicle plate number already exists.");
        }

        VehicleEntity vehicle = new VehicleEntity();

        vehicle.setPlateNumber(dto.getPlateNumber());
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        vehicle.setCapacity(dto.getCapacity());

        VehicleEntity savedVehicle = vehicleRepository.save(vehicle);

        // Link Driver and Vehicle
        driver.setVehicle(savedVehicle);

        // Driver becomes ACTIVE
        driver.setDriverStatus("ACTIVE");

        driverRepository.save(driver);

        return mapToResponse(savedVehicle);
    }

    // ===========================
    // GET ALL VEHICLES
    // ===========================
    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ===========================
    // GET VEHICLE BY ID
    // ===========================
    public VehicleResponseDTO getVehicleById(Long id) {

        VehicleEntity vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found."));

        return mapToResponse(vehicle);
    }

    // ===========================
    // UPDATE VEHICLE
    // ===========================
    public VehicleResponseDTO updateVehicle(Long id, VehicleRequestDTO dto) {

        VehicleEntity vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found."));

        vehicle.setPlateNumber(dto.getPlateNumber());
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        vehicle.setCapacity(dto.getCapacity());

        VehicleEntity updatedVehicle = vehicleRepository.save(vehicle);

        return mapToResponse(updatedVehicle);
    }

    // ===========================
    // DELETE VEHICLE
    // ===========================
    public void deleteVehicle(Long id) {

        VehicleEntity vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found."));

        vehicleRepository.delete(vehicle);
    }

    // ===========================
    // MAP ENTITY TO DTO
    // ===========================
    private VehicleResponseDTO mapToResponse(VehicleEntity vehicle) {

        VehicleResponseDTO dto = new VehicleResponseDTO();

        dto.setVehicleId(vehicle.getVehicleId());
        dto.setPlateNumber(vehicle.getPlateNumber());
        dto.setBrand(vehicle.getBrand());
        dto.setModel(vehicle.getModel());
        dto.setCapacity(vehicle.getCapacity());

        return dto;
    }
}