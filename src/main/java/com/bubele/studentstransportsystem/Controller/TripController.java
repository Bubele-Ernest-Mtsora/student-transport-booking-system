package com.bubele.studentstransportsystem.Controller;

import com.bubele.studentstransportsystem.Dto.TripRequestDTO;
import com.bubele.studentstransportsystem.Dto.TripResponseDTO;
import com.bubele.studentstransportsystem.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    // CREATE
    @PostMapping
    public TripResponseDTO createTrip(@RequestBody TripRequestDTO dto) {
        return tripService.createTrip(dto);
    }

    // GET ALL
    @GetMapping
    public List<TripResponseDTO> getAllTrips() {
        return tripService.getAllTrips();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public TripResponseDTO getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public TripResponseDTO updateTrip(
            @PathVariable Long id,
            @RequestBody TripRequestDTO dto) {

        return tripService.updateTrip(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
    }
}