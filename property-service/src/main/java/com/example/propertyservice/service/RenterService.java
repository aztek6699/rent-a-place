package com.example.propertyservice.service;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.model.RenterModel;
import com.example.propertyservice.repo.RenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenterService {

    @Autowired
    private RenterRepo repo;

    public GenericResponse getAllRenters() {
        List<RenterModel> list = repo.findAll();

        if (list.isEmpty()) {
            return new GenericResponse(false, "No renters", 01, null);
        } else {
            return new GenericResponse(true, "Success", 00, list);
        }
    }

    public GenericResponse getRenterById(Long id) {
        Optional<RenterModel> renter = repo.findById(id);

        if (renter.isPresent()) {
            return new GenericResponse(true, "Renter found", 00, List.of(renter));
        } else {
            return new GenericResponse(false, "Renter not found", 01, null);
        }
    }

    public GenericResponse findRenterByEmailOrNumber(String email, String mobileNumber) {
        Optional<RenterModel> renter = repo.findByEmailOrMobileNumber(email, mobileNumber);

        if (renter.isPresent()) {
            return new GenericResponse(true, "Renter found", 00, List.of(renter));
        } else {
            return new GenericResponse(false, "Renter not found", 01, null);
        }
    }

    public GenericResponse insertRenter(RenterModel newRenter) {
        Optional<RenterModel> renter = repo.findByEmailOrMobileNumber(newRenter.getEmail(), newRenter.getMobileNumber());

        if (renter.isEmpty()) {
            repo.save(newRenter);
            return new GenericResponse(true, "Renter added", 00, null);
        } else {
            return new GenericResponse(false, "Email or/and mobile number must be unique", 01, null);
        }
    }
}
