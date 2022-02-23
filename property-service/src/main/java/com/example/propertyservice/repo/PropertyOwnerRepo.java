package com.example.propertyservice.repo;

import com.example.propertyservice.model.PropertyOwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyOwnerRepo extends JpaRepository<PropertyOwnerModel, Long> {

    @Query(value = "SELECT * FROM property_owner WHERE email = :email || mobile_number = :mobileNumber", nativeQuery = true)
    Optional<PropertyOwnerModel> findOwnerByEmailOrMobileNumber(String email, String mobileNumber);
}
