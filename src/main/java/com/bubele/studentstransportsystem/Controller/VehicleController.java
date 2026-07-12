package com.bubele.studentstransportsystem.Controller;

import com.bubele.studentstransportsystem.Dto.VehicleRequestDTO;
import com.bubele.studentstransportsystem.Dto.VehicleResponseDTO;
import com.bubele.studentstransportsystem.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/register")
    public ResponseEntity<VehicleResponseDTO> registerVehicle(
            @RequestBody VehicleRequestDTO dto) {

        VehicleResponseDTO response = vehicleService.createVehicle(dto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> updateVehicle(
            @PathVariable Long id,
            @RequestBody VehicleRequestDTO dto) {

        return ResponseEntity.ok(vehicleService.updateVehicle(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {

        vehicleService.deleteVehicle(id);

        return ResponseEntity.ok("Vehicle deleted successfully.");
    }
}