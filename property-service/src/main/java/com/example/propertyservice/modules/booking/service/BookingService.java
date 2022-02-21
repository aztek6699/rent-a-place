package com.example.propertyservice.modules.booking.service;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.modules.booking.model.BookingModel;
import com.example.propertyservice.modules.booking.repo.BookingRepo;
import com.example.propertyservice.modules.property.model.PropertyModel;
import com.example.propertyservice.modules.property.repo.PropertyRepo;
import com.example.propertyservice.modules.renter.model.RenterModel;
import com.example.propertyservice.modules.renter.repo.RenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    private RenterRepo renterRepo;

    public GenericResponse insertBooking(Long propertyId, Long renterId, BookingModel newBooking) {

        // check if property exists
        Optional<PropertyModel> property = propertyRepo.findById(propertyId);
        if (property.isEmpty()) return new GenericResponse(false, "Property does not exist", 01, null);

        // check if renter exists
        Optional<RenterModel> renter = renterRepo.findById(renterId);
        if (renter.isEmpty()) return new GenericResponse(false, "renter does not exist", 01, null);

        // check
        List<BookingModel> bookingList = bookingRepo.findAllByPropertyId(propertyId);

        Date newStartDate = newBooking.getStartDate();

        for (BookingModel booking : bookingList) {
            if (newStartDate.after(booking.getStartDate()) && newStartDate.before(booking.getEndDate())) {
                return new GenericResponse(false, "Dates already taken", 01, null);
            }
        }

        bookingRepo.save(newBooking);
        return new GenericResponse(true, "Booking inserted", 00, null);
    }
}
