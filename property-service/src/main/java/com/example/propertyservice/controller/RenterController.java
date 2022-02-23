package com.example.propertyservice.controller;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.model.RenterModel;
import com.example.propertyservice.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/renter")
public class RenterController {

    @Autowired
    private RenterService service;

    @GetMapping("")
    public ResponseEntity<GenericResponse> getAllRenters() {
        return ResponseEntity.ok(service.getAllRenters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getRenterById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRenterById(id));
    }

    @PostMapping("")
    public ResponseEntity<GenericResponse> insertRenter(@RequestBody RenterModel newRenter) {
        return ResponseEntity.ok(service.insertRenter(newRenter));
    }
}
