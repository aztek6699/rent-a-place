package com.example.propertyservice.service;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.model.PropertyOwnerModel;
import com.example.propertyservice.repo.PropertyOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyOwnerService {

    @Autowired
    private PropertyOwnerRepo repo;

    public List<PropertyOwnerModel> getAllOwners() {
        return repo.findAll();
    }

    public PropertyOwnerModel getPropertyOwnerById(@PathVariable Long id) {
        return repo.findById(id).orElseGet(PropertyOwnerModel::new);
    }

    public GenericResponse insertOwner(PropertyOwnerModel newOwner) {

        Optional<PropertyOwnerModel> owner = repo.findByEmailOrMobileNumber(newOwner.getEmail(), newOwner.getMobileNumber());

        if (owner.isEmpty()) {
            repo.save(newOwner);
            return new GenericResponse(true, "Insert Successful", 00, null);
        } else {
            return new GenericResponse(false, "Email and/or mobile number must be unique", 01, null);
        }
    }

    public GenericResponse updateOwner(PropertyOwnerModel updateOwner) {
        Optional<PropertyOwnerModel> ownerExist = repo.findById(updateOwner.getId());

        if (ownerExist.isPresent()) {
            ownerExist = repo.findByEmailOrMobileNumber(updateOwner.getEmail(), updateOwner.getMobileNumber());

            if (ownerExist.isPresent()) {
                return new GenericResponse(false, "Email or mobile number already taken", 01, null);
            } else {
                repo.save(updateOwner);
                return new GenericResponse(true, "Update successful", 00, null);
            }
        } else {
            return new GenericResponse(false, "User does not exit", 01, null);
        }
    }
}
