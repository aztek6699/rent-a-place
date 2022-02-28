package com.example.propertyservice.service;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.model.BookingModel;
import com.example.propertyservice.repo.BookingRepo;
import com.example.propertyservice.model.PropertyModel;
import com.example.propertyservice.repo.PropertyRepo;
import com.example.propertyservice.model.RenterModel;
import com.example.propertyservice.repo.RenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
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

    // TODO complete it later
    public GenericResponse getAllBookingsByRenterId(Long renterId) {

        Optional<RenterModel> renter = renterRepo.findById(renterId);

        if (renter.isEmpty()) return new GenericResponse(false, "Renter does not exist", 01, null);

        // get list of bookings
        //List<Long> renterIdList = bookingRepo.findAllByRenterId(renterId);

        // check if renter has any bookings
        //if (renterIdList.isEmpty()) return new GenericResponse(false, "Renter has no bookings", 01, null);

        // get list of booking
        return new GenericResponse(true, "fonund", 00, bookingRepo.findAllByRenterId(renterId));
    }

    public GenericResponse getAllBookingsByPropertyId(Long propertyId) {

        List<BookingModel> list = bookingRepo.findAllByPropertyId(propertyId);

        if (list.isEmpty()) {
            return new GenericResponse(false, "No bookings for property", 01, null);
        } else {
            return new GenericResponse(true, "Success", 00, list);
        }
    }

    public GenericResponse insertBooking(Long propertyId, Long renterId, BookingModel newBooking) {

        // check if end date after start date
        if (!newBooking.getEndDate().after(newBooking.getStartDate()))
            return new GenericResponse(false, "End date must be after start date", 01, null);

        // check if property exists
        Optional<PropertyModel> property = propertyRepo.findById(propertyId);
        if (property.isEmpty()) return new GenericResponse(false, "Property does not exist", 01, null);

        // check if renter exists
        Optional<RenterModel> renter = renterRepo.findById(renterId);
        if (renter.isEmpty()) return new GenericResponse(false, "renter does not exist", 01, null);

        // check if dates already taken
        List<BookingModel> bookingList = bookingRepo.findAllByPropertyId(propertyId);
        Date newStartDate = newBooking.getStartDate();
        for (BookingModel booking : bookingList) {
            if (newStartDate.after(booking.getStartDate()) && newStartDate.before(booking.getEndDate())) {
                return new GenericResponse(false, "Dates already taken", 01, null);
            }
        }

        // insert booking
        newBooking.setProperty(property.get());
        newBooking.setRenter(renter.get());

        bookingRepo.save(newBooking);
        return new GenericResponse(true, "Booking inserted", 00, null);
    }
}
