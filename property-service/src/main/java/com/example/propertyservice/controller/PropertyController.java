package com.example.propertyservice.controller;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.model.PropertyModel;
import com.example.propertyservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @GetMapping("")
    public ResponseEntity<GenericResponse> getAllProperties() {
        return ResponseEntity.ok(service.getAllProperties());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getPropertyById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPropertyById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<GenericResponse> insertProperty(@PathVariable long id, @RequestBody PropertyModel newProperty) {
        return ResponseEntity.ok(service.insertProperty(id, newProperty));
    }

}
