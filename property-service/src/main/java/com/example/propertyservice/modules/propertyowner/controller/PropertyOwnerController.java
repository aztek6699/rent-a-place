package com.example.propertyservice.modules.propertyowner.controller;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.modules.propertyowner.model.PropertyOwnerModel;
import com.example.propertyservice.modules.propertyowner.service.PropertyOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/propertyOwner")
public class PropertyOwnerController {

    @Autowired
    private PropertyOwnerService service;

    @GetMapping("")
    public ResponseEntity<GenericResponse> getAllOwners() {

        List<PropertyOwnerModel> list = service.getAllOwners();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(new GenericResponse(true, "Success", 00, list));
        } else {
            return ResponseEntity.ok(new GenericResponse(false, "No Property Owners Found", 01, null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getOwnerById(@PathVariable Long id) {
        PropertyOwnerModel dto = service.getPropertyOwnerById(id);
        if (dto != null) {
            return ResponseEntity.ok(new GenericResponse(true, "Success", 00, List.of(dto)));
        } else {
            return ResponseEntity.ok(new GenericResponse(false, "No Property Owners Found", 01, null));
        }
    }

    @PostMapping("")
    public ResponseEntity<GenericResponse> insertPropertyOwner(@RequestBody PropertyOwnerModel newOwner) {
        return ResponseEntity.ok(service.insertOwner(newOwner));
    }

    @PutMapping("")
    public ResponseEntity<GenericResponse> updatePropertyOwner(@RequestBody PropertyOwnerModel updateOwner) {
        return ResponseEntity.ok(service.updateOwner(updateOwner));
    }
}
