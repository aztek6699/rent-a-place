package com.example.propertyservice.modules.property.service;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.modules.location.model.LocationModel;
import com.example.propertyservice.modules.location.repo.LocationRepo;
import com.example.propertyservice.modules.property.model.PropertyModel;
import com.example.propertyservice.modules.property.repo.PropertyRepo;
import com.example.propertyservice.modules.propertyowner.model.PropertyOwnerModel;
import com.example.propertyservice.modules.propertyowner.repo.PropertyOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    private LocationRepo locationRepo;

    @Autowired
    private PropertyOwnerRepo propertyOwnerRepo;

    @Autowired

    public GenericResponse getAllProperties() {
        List<PropertyModel> list = propertyRepo.findAll();

        if (!list.isEmpty()) {
            return new GenericResponse(true, "Success", 00, list);
        } else {
            return new GenericResponse(false, "No properties found", 01, null);
        }
    }

    public GenericResponse getPropertyById(Long id) {
        Optional<PropertyModel> property = propertyRepo.findById(id);

        if (property.isPresent()) {
            return new GenericResponse(true, "Property found", 00, List.of(property));
        } else {
            return new GenericResponse(false, "Property not found", 01, null);
        }
    }

    public GenericResponse insertProperty(Long ownerId, PropertyModel newProperty) {

        Optional<PropertyOwnerModel> propertyOwner = propertyOwnerRepo.findById(ownerId);

        if (propertyOwner.isPresent()) {
            newProperty.setPropertyOwner(propertyOwner.get());

            LocationModel location = newProperty.getLocation();
            if (location != null) {
                // check if address already exist
                if (locationRepo.findLocationByAddress(location.getAddress()).isEmpty()) {

                    locationRepo.save(location);
                    propertyRepo.save(newProperty);
                    location.setProperty(newProperty);
                    locationRepo.save(location);

                    return new GenericResponse(true, "Property added", 00, null);
                } else {
                    return new GenericResponse(false, "Address already exists", 01, null);
                }
            } else {
                return new GenericResponse(false, "Location must not be null", 01, null);
            }
        } else {
            return new GenericResponse(false, "Owner must not be null", 01, null);
        }
    }
}
