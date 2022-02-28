package com.example.propertyservice.repo;

import com.example.propertyservice.model.PropertyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends JpaRepository<PropertyModel, Long> {

    List<PropertyModel> findAllByLocation_City(String city);
    List<PropertyModel> findAllByLocation_Country(String country);


}
