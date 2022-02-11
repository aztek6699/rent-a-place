package com.example.userservice.propertyowner.repo;

import com.example.userservice.propertyowner.model.PropertyOwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyOwnerRepo extends JpaRepository<PropertyOwnerModel, Long> {

    @Query("SELECT * FROM property_owner WHERE email = :email || mobile_number = :mobileNumber")
    Optional<PropertyOwnerModel> findOwnerByEmailOrMobileNumber(String email, String mobileNumber);
}
