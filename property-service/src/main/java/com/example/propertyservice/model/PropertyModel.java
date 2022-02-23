package com.example.propertyservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PropertyModel {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_owner_id", nullable = false)
    private PropertyOwnerModel propertyOwner;

    @OneToOne(mappedBy = "property")
    @PrimaryKeyJoinColumn
    private LocationModel location;

    @OneToMany(mappedBy = "property")
    private List<BookingModel> bookings;

    @OneToMany(mappedBy = "property")
    private List<ReviewModel> reviews;

    private String amenities;
    private String description;
    private Time check_in_time;
    private Time check_out_time;
    private int guest_capacity;
    private String picture;
    private float price;
    private String type;
}
