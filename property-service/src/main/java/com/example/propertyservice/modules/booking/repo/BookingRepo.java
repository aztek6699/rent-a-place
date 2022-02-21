package com.example.propertyservice.modules.booking.repo;

import com.example.propertyservice.modules.booking.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<BookingModel, Long> {

    @Query(value = "SELECT * FROM renter WHERE property_id = :propertyId", nativeQuery = true)
    List<BookingModel> findAllByPropertyId(Long propertyId);
}
