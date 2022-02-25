package com.example.propertyservice.controller;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.model.BookingModel;
import com.example.propertyservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/booking")
public class BookingController {

    @Autowired
    private BookingService service;

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getAllBookingsByPropertyId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAllBookingsByPropertyId(id));
    }

    @PostMapping("")
    public ResponseEntity<GenericResponse> insertBooking(@RequestHeader Long propertyId, @RequestHeader Long renterId, @RequestBody BookingModel booking) {
        return ResponseEntity.ok(service.insertBooking(propertyId, renterId, booking));
    }
}
