package com.example.propertyservice.modules.location.service;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.modules.location.model.LocationModel;
import com.example.propertyservice.modules.location.repo.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepo repo;

    public GenericResponse insertLocation(LocationModel newLocation) {
        Optional<LocationModel> location = repo.findLocationByAddress(newLocation.getAddress());

        if (location.isPresent()) {
            return new GenericResponse(false, "Address must be unique", 01, null);
        } else {
            return new GenericResponse(true, "Location inserted", 00, null);
        }
    }

    public GenericResponse getAllLocations() {
        List<LocationModel> list = repo.findAll();

        if (list.isEmpty()) {
            return new GenericResponse(true, "No locations found", 01, null);
        } else {
            return new GenericResponse(false, "Success", 00, list);
        }
    }

    public GenericResponse getLocationByAddress(String address) {
        Optional<LocationModel> location = repo.findLocationByAddress(address);

        if (location.isPresent()) {
            return new GenericResponse(true, "Location found", 00, List.of(location));
        } else {
            return new GenericResponse(false, "Location by address not found", 01, null);
        }
    }

    public GenericResponse getLocationByCity(String city) {
        Optional<List<LocationModel>> list = repo.findLocationByCity(city);

        if (list.isPresent() && !list.get().isEmpty()) {
            return new GenericResponse(true, "Location found", 00, list.get());
        } else {
            return new GenericResponse(false, "Locations by city not found", 01, null);
        }
    }

    public GenericResponse getLocationByCountry(String country) {
        Optional<List<LocationModel>> list = repo.findLocationByCountry(country);

        if (list.isPresent() && !list.get().isEmpty()) {
            return new GenericResponse(true, "Location found", 00, list.get());
        } else {
            return new GenericResponse(false, "Locations by country not found", 01, null);
        }
    }
}
