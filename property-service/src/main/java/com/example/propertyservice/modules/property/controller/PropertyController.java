package com.example.propertyservice.modules.property.controller;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.modules.property.model.PropertyModel;
import com.example.propertyservice.modules.property.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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
    public ResponseEntity<GenericResponse> getPropertyById(@RequestParam Long id) {
        return ResponseEntity.ok(service.getPropertyById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<GenericResponse> insertProperty(@RequestParam long id, @RequestBody PropertyModel newProperty) {
        return ResponseEntity.ok(service.insertProperty(id, newProperty));
    }

}
