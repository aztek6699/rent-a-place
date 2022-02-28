package com.example.propertyservice.repo;

import com.example.propertyservice.model.PropertyOwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyOwnerRepo extends JpaRepository<PropertyOwnerModel, Long> {

    Optional<PropertyOwnerModel> findByEmailOrMobileNumber(String email, String mobileNumber);
}
