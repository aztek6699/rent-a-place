package com.example.propertyservice.repo;

import com.example.propertyservice.model.RenterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RenterRepo extends JpaRepository<RenterModel, Long> {

    Optional<RenterModel> findByEmailOrMobileNumber(String email, String mobileNumber);
}
