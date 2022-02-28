package com.example.propertyservice.repo;

import com.example.propertyservice.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<BookingModel, Long> {

    List<BookingModel> findAllByPropertyId(Long propertyId);
    List<Long> findAllByRenterId(Long renterId);
}
