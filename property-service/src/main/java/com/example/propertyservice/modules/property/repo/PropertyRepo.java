package com.example.propertyservice.modules.property.repo;

import com.example.propertyservice.modules.property.model.PropertyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepo extends JpaRepository<PropertyModel, Long> {
}
