package com.bubele.studentstransportsystem.Service;

import com.bubele.studentstransportsystem.Dto.DriverLoginRequestDTO;
import com.bubele.studentstransportsystem.Dto.DriverLoginResponseDTO;
import com.bubele.studentstransportsystem.Dto.DriverRequestDTO;
import com.bubele.studentstransportsystem.Dto.DriverResponseDTO;
import com.bubele.studentstransportsystem.Entity.DriverEntity;
import com.bubele.studentstransportsystem.Repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    // ==========================
    // CREATE DRIVER
    // ==========================
    public DriverResponseDTO createDriver(DriverRequestDTO dto) {

        DriverEntity driver = new DriverEntity();

        driver.setFullName(dto.getFullName());
        driver.setLicenseNumber(dto.getLicenseNumber());
        driver.setPhoneNumber(dto.getPhoneNumber());
        driver.setEmail(dto.getEmail());
        driver.setPassword(dto.getPassword());

        // Driver starts as PENDING
        driver.setDriverStatus("PENDING");

        DriverEntity saved = driverRepository.save(driver);

        return mapToResponse(saved);
    }

    // ==========================
    // DRIVER LOGIN
    // ==========================
    public DriverLoginResponseDTO loginDriver(DriverLoginRequestDTO dto) {

        DriverEntity driver = driverRepository.findByEmail(dto.getEmail()).orElse(null);

        DriverLoginResponseDTO response = new DriverLoginResponseDTO();

        if (driver == null) {
            response.setMessage("Driver not found.");
            return response;
        }

        if (!driver.getPassword().equals(dto.getPassword())) {
            response.setMessage("Incorrect password.");
            return response;
        }

        response.setDriverId(driver.getDriverId());
        response.setFullName(driver.getFullName());
        response.setEmail(driver.getEmail());
        response.setDriverStatus(driver.getDriverStatus());

        if ("PENDING".equals(driver.getDriverStatus())) {
            response.setMessage("Login successful. Please register your vehicle.");
        } else {
            response.setMessage("Login successful.");
        }

        return response;
    }

    // ==========================
    // GET ALL DRIVERS
    // ==========================
    public List<DriverResponseDTO> getAllDrivers() {

        return driverRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================
    // GET DRIVER BY ID
    // ==========================
    public DriverResponseDTO getDriverById(Long id) {

        DriverEntity driver = driverRepository.findById(id).orElse(null);

        if (driver == null) {
            return null;
        }

        return mapToResponse(driver);
    }

    // ==========================
    // UPDATE DRIVER
    // ==========================
    public DriverResponseDTO updateDriver(Long id, DriverRequestDTO dto) {

        DriverEntity driver = driverRepository.findById(id).orElse(null);

        if (driver == null) {
            return null;
        }

        driver.setFullName(dto.getFullName());
        driver.setLicenseNumber(dto.getLicenseNumber());
        driver.setPhoneNumber(dto.getPhoneNumber());
        driver.setEmail(dto.getEmail());
        driver.setPassword(dto.getPassword());

        DriverEntity updated = driverRepository.save(driver);

        return mapToResponse(updated);
    }

    // ==========================
    // DELETE DRIVER
    // ==========================
    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }

    // ==========================
    // ENTITY -> RESPONSE DTO
    // ==========================
    private DriverResponseDTO mapToResponse(DriverEntity driver) {

        DriverResponseDTO dto = new DriverResponseDTO();

        dto.setDriverId(driver.getDriverId());
        dto.setFullName(driver.getFullName());
        dto.setLicenseNumber(driver.getLicenseNumber());
        dto.setPhoneNumber(driver.getPhoneNumber());
        dto.setEmail(driver.getEmail());

        dto.setDriverStatus(driver.getDriverStatus());

        if (driver.getVehicle() != null) {
            dto.setVehiclePlateNumber(driver.getVehicle().getPlateNumber());
        }

        return dto;
    }

}