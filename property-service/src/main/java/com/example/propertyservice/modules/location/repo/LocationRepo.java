package com.example.propertyservice.modules.location.repo;

import com.example.propertyservice.modules.location.model.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<LocationModel, Long> {
}
