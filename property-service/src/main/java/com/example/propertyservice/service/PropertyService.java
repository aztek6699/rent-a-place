package com.example.propertyservice.service;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.model.LocationModel;
import com.example.propertyservice.model.PropertyModel;
import com.example.propertyservice.model.PropertyOwnerModel;
import com.example.propertyservice.repo.LocationRepo;
import com.example.propertyservice.repo.PropertyOwnerRepo;
import com.example.propertyservice.repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Value("${redis.key.property}")
    private String propertyKey;

    private final PropertyRepo propertyRepo;
    private final LocationRepo locationRepo;
    private final PropertyOwnerRepo propertyOwnerRepo;

    // HashOperations<KEY, ID, TYPE>
    private final HashOperations<String, Long, PropertyModel> propertyHashOperations;

    @Autowired
    public PropertyService(PropertyRepo propertyRepo,
                           LocationRepo locationRepo,
                           PropertyOwnerRepo propertyOwnerRepo,
                           RedisTemplate<String, PropertyModel> redisTemplate) {

        this.propertyRepo = propertyRepo;
        this.locationRepo = locationRepo;
        this.propertyOwnerRepo = propertyOwnerRepo;
        propertyHashOperations = redisTemplate.opsForHash();
    }

    @CachePut(value = "property")
    public GenericResponse getAllProperties() {
        List<PropertyModel> list = propertyRepo.findAll();

        if (!list.isEmpty()) {
            return new GenericResponse(true, "Success", 00, list);
        } else {
            return new GenericResponse(false, "No properties found", 01, null);
        }
    }

    public GenericResponse getPropertyById(Long id) {
        Optional<PropertyModel> property;
        property = Optional.ofNullable(propertyHashOperations.get(propertyKey, id));

        if (property.isPresent()) return new GenericResponse(true, "Property found", 00, List.of(property));

        property = propertyRepo.findById(id);
        if (property.isPresent()) {
            propertyHashOperations.put(propertyKey, id, property.get());
            return new GenericResponse(true, "Property found", 00, List.of(property));
        } else {
            return new GenericResponse(false, "Property not found", 01, null);
        }
    }

    public GenericResponse insertProperty(Long ownerId, PropertyModel newProperty) {

        // check if property owner exists
        Optional<PropertyOwnerModel> propertyOwner = propertyOwnerRepo.findById(ownerId);
        if (propertyOwner.isEmpty()) return new GenericResponse(false, "Owner must not be null", 01, null);

        // check if check in time after check out time
        if (!newProperty.getCheck_in_time().after(newProperty.getCheck_out_time()))
            return new GenericResponse(false, "Check in time must be after check out time", 01, null);

        // check if location is not null
        LocationModel location = newProperty.getLocation();
        if (location == null) return new GenericResponse(false, "Location must not be null", 01, null);

        // check if location with address exist
        if (locationRepo.findLocationByAddress(location.getAddress()).isPresent())
            return new GenericResponse(false, "Address already exists", 01, null);

        // insert property, done to maintain the coherence of the object graph, id of location is the id of the property
        newProperty.setPropertyOwner(propertyOwner.get());
        location.setProperty(newProperty);
        propertyRepo.save(newProperty);

        // put new property in cache
        propertyHashOperations.put(propertyKey, newProperty.getId(), newProperty);
        return new GenericResponse(true, "Property added", 00, null);
    }

    @CacheEvict(value = "property", allEntries = true)
    public String evictAllCacheValues() {
        return "evict all";
    }
}
