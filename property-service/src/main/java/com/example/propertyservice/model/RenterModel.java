package com.example.propertyservice.model;

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
    @Column(name = "mobile_number")
    private String mobileNumber;
    private String email;
    private Date dob;

    @OneToMany(mappedBy = "renter")
    private List<BookingModel> bookings;
}
