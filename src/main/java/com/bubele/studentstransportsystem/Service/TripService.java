package com.bubele.studentstransportsystem.Service;

import com.bubele.studentstransportsystem.Dto.TripRequestDTO;
import com.bubele.studentstransportsystem.Dto.TripResponseDTO;
import com.bubele.studentstransportsystem.Entity.DriverEntity;
import com.bubele.studentstransportsystem.Entity.TripEntity;
import com.bubele.studentstransportsystem.Entity.VehicleEntity;
import com.bubele.studentstransportsystem.Repository.DriverRepository;
import com.bubele.studentstransportsystem.Repository.TripRepository;
import com.bubele.studentstransportsystem.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    // CREATE
    public TripResponseDTO createTrip(TripRequestDTO dto) {

        DriverEntity driver =
                driverRepository.findById(dto.getDriverId()).orElse(null);

        VehicleEntity vehicle =
                vehicleRepository.findById(dto.getVehicleId()).orElse(null);

        if(driver == null || vehicle == null){
            return null;
        }

        TripEntity trip = new TripEntity();

        trip.setDepartureLocation(dto.getDepartureLocation());
        trip.setDestinationLocation(dto.getDestinationLocation());
        trip.setDepartureDate(dto.getDepartureDate());
        trip.setDepartureTime(dto.getDepartureTime());
        trip.setPrice(dto.getPrice());
        trip.setAvailableSeats(dto.getAvailableSeats());

        trip.setDriver(driver);
        trip.setVehicle(vehicle);

        TripEntity saved = tripRepository.save(trip);

        return mapToResponse(saved);
    }

    // GET ALL
    public List<TripResponseDTO> getAllTrips() {

        return tripRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public TripResponseDTO getTripById(Long id) {

        TripEntity trip = tripRepository.findById(id).orElse(null);

        return trip != null ? mapToResponse(trip) : null;
    }

    // UPDATE
    public TripResponseDTO updateTrip(Long id, TripRequestDTO dto) {

        TripEntity trip = tripRepository.findById(id).orElse(null);

        if(trip == null){
            return null;
        }

        DriverEntity driver =
                driverRepository.findById(dto.getDriverId()).orElse(null);

        VehicleEntity vehicle =
                vehicleRepository.findById(dto.getVehicleId()).orElse(null);

        if(driver == null || vehicle == null){
            return null;
        }

        trip.setDepartureLocation(dto.getDepartureLocation());
        trip.setDestinationLocation(dto.getDestinationLocation());
        trip.setDepartureDate(dto.getDepartureDate());
        trip.setDepartureTime(dto.getDepartureTime());
        trip.setPrice(dto.getPrice());
        trip.setAvailableSeats(dto.getAvailableSeats());

        trip.setDriver(driver);
        trip.setVehicle(vehicle);

        TripEntity updated = tripRepository.save(trip);

        return mapToResponse(updated);
    }

    // DELETE
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    // MAPPING METHOD
    private TripResponseDTO mapToResponse(TripEntity trip) {

        TripResponseDTO dto = new TripResponseDTO();

        dto.setTripId(trip.getTripId());
        dto.setDepartureLocation(trip.getDepartureLocation());
        dto.setDestinationLocation(trip.getDestinationLocation());
        dto.setDepartureDate(trip.getDepartureDate());
        dto.setDepartureTime(trip.getDepartureTime());
        dto.setPrice(trip.getPrice());
        dto.setAvailableSeats(trip.getAvailableSeats());

        dto.setDriverName(trip.getDriver().getFullName());
        dto.setVehiclePlateNumber(
                trip.getVehicle().getPlateNumber()
        );

        return dto;
    }
}