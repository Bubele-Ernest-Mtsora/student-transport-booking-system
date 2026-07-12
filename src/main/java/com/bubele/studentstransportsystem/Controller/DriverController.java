package com.bubele.studentstransportsystem.Controller;

import com.bubele.studentstransportsystem.Dto.DriverLoginRequestDTO;
import com.bubele.studentstransportsystem.Dto.DriverLoginResponseDTO;
import com.bubele.studentstransportsystem.Dto.DriverRequestDTO;
import com.bubele.studentstransportsystem.Dto.DriverResponseDTO;
import com.bubele.studentstransportsystem.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    // CREATE DRIVER
    @PostMapping("/create")
    public DriverResponseDTO createDriver(@RequestBody DriverRequestDTO dto) {
        return driverService.createDriver(dto);
    }

    // DRIVER LOGIN
    @PostMapping("/login")
    public DriverLoginResponseDTO loginDriver(@RequestBody DriverLoginRequestDTO dto) {
        return driverService.loginDriver(dto);
    }

    // GET ALL DRIVERS
    @GetMapping("/all")
    public List<DriverResponseDTO> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    // GET DRIVER BY ID
    @GetMapping("/{id}")
    public DriverResponseDTO getDriverById(@PathVariable Long id) {
        return driverService.getDriverById(id);
    }

    // UPDATE DRIVER
    @PutMapping("/{id}")
    public DriverResponseDTO updateDriver(@PathVariable Long id,
                                          @RequestBody DriverRequestDTO dto) {
        return driverService.updateDriver(id, dto);
    }

    // DELETE DRIVER
    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
    }
}