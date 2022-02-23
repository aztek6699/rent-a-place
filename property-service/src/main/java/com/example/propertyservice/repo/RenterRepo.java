package com.example.propertyservice.repo;

import com.example.propertyservice.model.RenterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RenterRepo extends JpaRepository<RenterModel, Long> {

    @Query(value = "SELECT * FROM renter WHERE email = :email || mobile_number = :mobileNumber", nativeQuery = true)
    Optional<RenterModel> findOwnerByEmailOrMobileNumber(String email, String mobileNumber);
}
