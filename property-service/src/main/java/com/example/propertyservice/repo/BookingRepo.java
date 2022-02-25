package com.example.propertyservice.repo;

import com.example.propertyservice.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<BookingModel, Long> {

    @Query(value = "SELECT * FROM booking WHERE property_id = :propertyId", nativeQuery = true)
    List<BookingModel> findAllByPropertyId(Long propertyId);

    @Query(value = "SELECT * FROM booking where renter_id = :renterId", nativeQuery = true)
    List<Long> findAllByRenterId(Long renterId);
}
