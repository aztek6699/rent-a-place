package com.example.userservice.propertyowner.service;

import com.example.userservice.model.GenericResponse;
import com.example.userservice.propertyowner.model.PropertyOwnerModel;
import com.example.userservice.propertyowner.repo.PropertyOwnerRepo;
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

        Optional<PropertyOwnerModel> owner = repo.findOwnerByEmailOrMobileNumber(newOwner.getEmail(), newOwner.getMobile_number());

        if (owner.isPresent()) {
            repo.save(newOwner);
            return new GenericResponse(true, "Insert Successful", 00, null);
        } else {
            return new GenericResponse(false, "Email and/or mobile number must be unique", 01, null);
        }
    }

    public GenericResponse updateOwner(PropertyOwnerModel updateOwner) {
        Optional<PropertyOwnerModel> dto = repo.findById(updateOwner.getHost_id());

        if (dto.isPresent()) {
            PropertyOwnerModel owner = dto.get();

            if (owner.getEmail().equals(updateOwner.getEmail()) || owner.getMobile_number().equals(updateOwner.getMobile_number())) {
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
