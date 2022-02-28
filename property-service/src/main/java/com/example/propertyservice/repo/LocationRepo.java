package com.example.propertyservice.repo;

import com.example.propertyservice.model.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepo extends JpaRepository<LocationModel, Long> {

    Optional<LocationModel> findLocationByAddress(String address);
    List<Long> findLocationByCity(String city);
    List<Long> findLocationByCountry(String country);
}
