package com.example.propertyservice.service;

import com.example.propertyservice.model.BookingModel;
import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.model.PropertyModel;
import com.example.propertyservice.model.ReviewModel;
import com.example.propertyservice.repo.BookingRepo;
import com.example.propertyservice.repo.PropertyRepo;
import com.example.propertyservice.repo.RenterRepo;
import com.example.propertyservice.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public GenericResponse insertReview(Long bookingId, ReviewModel newReview) {

        // check if booking exist
        Optional<BookingModel> booking = bookingRepo.findById(bookingId);
        if (booking.isEmpty()) return new GenericResponse(false, "Booking not found", 01, null);

        // check if booking already has review
        if (booking.get().getReview() != null)
            return new GenericResponse(false, "Booking already has review", 01, null);

        // check if property exist
        Optional<PropertyModel> property = propertyRepo.findById(booking.get().getProperty().getId());
        if (property.isEmpty()) return new GenericResponse(false, "Property not found", 01, null);

        // check if rating between 1 - 5
        if (newReview.getRating() >= 1 && newReview.getRating() <= 5)
            return new GenericResponse(false, "Rating must be between 1 -5", 01, null);

        // insert review
        newReview.setBooking(booking.get());
        newReview.setProperty(property.get());
        reviewRepo.save(newReview);
        return new GenericResponse(true, "Review inserted", 00, null);
    }
}
