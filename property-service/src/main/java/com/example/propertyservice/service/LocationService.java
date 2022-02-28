package com.example.propertyservice.service;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.model.LocationModel;
import com.example.propertyservice.model.PropertyModel;
import com.example.propertyservice.repo.LocationRepo;
import com.example.propertyservice.repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepo locationRepo;
    private final PropertyRepo propertyRepo;

    // HashOperations<KEY, ID, TYPE>
    private final HashOperations<String, Long, PropertyModel> propertyHashOperations;

    @Autowired
    public LocationService(LocationRepo locationRepo, PropertyRepo propertyRepo, RedisTemplate<String, PropertyModel> redisTemplate) {
        this.locationRepo = locationRepo;
        this.propertyRepo = propertyRepo;
        propertyHashOperations = redisTemplate.opsForHash();
    }

    public GenericResponse insertLocation(LocationModel newLocation) {
        Optional<LocationModel> location = locationRepo.findLocationByAddress(newLocation.getAddress());

        if (location.isPresent()) {
            return new GenericResponse(false, "Address must be unique", 01, null);
        } else {
            return new GenericResponse(true, "Location inserted", 00, null);
        }
    }

    public GenericResponse getAllLocations() {
        List<LocationModel> list = locationRepo.findAll();

        if (list.isEmpty()) {
            return new GenericResponse(true, "No locations found", 01, null);
        } else {
            return new GenericResponse(false, "Success", 00, list);
        }
    }

    public GenericResponse getLocationByAddress(String address) {
        Optional<LocationModel> location = locationRepo.findLocationByAddress(address);

        if (location.isPresent()) {
            return new GenericResponse(true, "Location found", 00, List.of(location));
        } else {
            return new GenericResponse(false, "Location by address not found", 01, null);
        }
    }

    @CachePut(value = "property")
    public GenericResponse getLocationByCity(String city) {
        List<PropertyModel> propertyList = propertyRepo.findAllByLocation_City(city);

        return new GenericResponse(true, "Locations found", 00, propertyList);
    }

    @CachePut(value = "property")
    public GenericResponse getLocationByCountry(String country) {
        List<PropertyModel> propertyList = propertyRepo.findAllByLocation_Country(country);

        return new GenericResponse(true, "Locations found", 00, propertyList);
    }

    public Boolean checkIfAddressExist(String address) {
        return locationRepo.findLocationByAddress(address).isPresent();
    }
}
