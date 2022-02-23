package com.example.propertyservice.repo;

import com.example.propertyservice.model.PropertyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepo extends JpaRepository<PropertyModel, Long> {
}
