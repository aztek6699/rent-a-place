package com.example.propertyservice.modules.property.service;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.modules.property.model.PropertyModel;
import com.example.propertyservice.modules.property.repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepo repo;

    public GenericResponse getAllProperties() {
        List<PropertyModel> list = repo.findAll();

        if (list.isEmpty()) {
            return new GenericResponse(true, "Success", 00, list);
        } else {
            return new GenericResponse(false, "No properties found", 01, null);
        }
    }

    public GenericResponse getAllPropertiesById(Long id) {
        Optional<PropertyModel> property = repo.findById(id);

        if (property.isPresent()) {
            return new GenericResponse(true, "Property found", 00, List.of(property));
        } else {
            return new GenericResponse(false, "Property not found", 01, null);
        }
    }

    public GenericResponse insertProperty() {

    }
}
