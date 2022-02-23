package com.example.propertyservice.service;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.model.BookingModel;
import com.example.propertyservice.repo.BookingRepo;
import com.example.propertyservice.repo.PropertyRepo;
import com.example.propertyservice.repo.RenterRepo;
import com.example.propertyservice.model.ReviewModel;
import com.example.propertyservice.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private RenterRepo renterRepo;

    @PostMapping("/{id}")
    public GenericResponse insertReview(@PathVariable Long id, @RequestBody ReviewModel newReview) {

        // check if booking exist
        Optional<BookingModel> booking = bookingRepo.findById(id);
        if (booking.isEmpty()) return new GenericResponse(false, "Booking not found", 01, null);

return null;
    }

}
