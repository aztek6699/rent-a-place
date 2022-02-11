package com.example.propertyservice.modules.location.controller;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.modules.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    @Autowired
    private LocationService service;

    @GetMapping("")
    public ResponseEntity<GenericResponse> getLocations() {
        return ResponseEntity.ok(service.getAllLocations());
    }

    @GetMapping("/{address}")
    public ResponseEntity<GenericResponse> getLocationByAddress(@PathVariable String address) {
        return ResponseEntity.ok(service.getLocationByAddress(address));
    }

    @GetMapping("/{city}")
    public ResponseEntity<GenericResponse> getLocationByCity(@PathVariable String city) {
        return ResponseEntity.ok(service.getLocationByAddress(city));
    }

    @GetMapping("/{country}")
    public ResponseEntity<GenericResponse> getLocationByCountry(@PathVariable String country) {
        return ResponseEntity.ok(service.getLocationByAddress(country));
    }
}
