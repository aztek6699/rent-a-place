package com.example.propertyservice.modules.property.model;

import com.example.propertyservice.modules.booking.model.BookingModel;
import com.example.propertyservice.modules.location.model.LocationModel;
import com.example.propertyservice.modules.propertyowner.model.PropertyOwnerModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "property")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PropertyModel {

    @Id
    private Long id;

    @ManyToOne
    private PropertyOwnerModel propertyOwner;

    @OneToOne
    @JoinColumn(name = "location_id")
    private LocationModel location;

    @OneToMany(mappedBy = "property")
    private List<BookingModel> bookings;

    private String amenities;
    private String description;
    private Time check_in_time;
    private Time check_out_time;
    private int guest_capacity;
    private String picture;
    private float price;
    private String type;
}
