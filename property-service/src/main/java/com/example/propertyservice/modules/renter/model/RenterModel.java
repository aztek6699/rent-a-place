package com.example.propertyservice.modules.renter.model;

import com.example.propertyservice.modules.booking.model.BookingModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "renter")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RenterModel {

    @Id
    private Long id;

    private String password;
    private String name;
    private String mobile_number;
    private String email;
    private Date dob;

    @OneToMany(mappedBy = "renter")
    private List<BookingModel> bookings;
}
