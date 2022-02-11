package com.example.propertyservice.modules.location.repo;

import com.example.propertyservice.modules.location.model.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepo extends JpaRepository<LocationModel, Long> {

    Optional<LocationModel> findLocationByAddress(String address);

    Optional<List<LocationModel>> findLocationByCity(String city);

    Optional<List<LocationModel>> findLocationByCountry(String country);
}
