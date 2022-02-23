package com.example.propertyservice.repo;

import com.example.propertyservice.model.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepo extends JpaRepository<LocationModel, Long> {

    Optional<LocationModel> findLocationByAddress(String address);

    @Query(value = "SELECT property_id FROM location WHERE city = :city", nativeQuery = true)
    List<Long> findLocationByCity(String city);

    @Query(value = "SELECT property_id FROM location WHERE country = :country", nativeQuery = true)
    List<Long> findLocationByCountry(String country);
}
