package com.example.userservice.model;

import com.example.userservice.propertyowner.model.PropertyOwnerModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "property")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PropertyModel {

    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="property_owner_id", referencedColumnName = "id")
    private PropertyOwnerModel propertyOwner;

    @OneToOne
    @JoinColumn(name = "location_id")
    private LocationModel location;

    private String amenities;
    private String description;
    private Time check_in_time;
    private Time check_out_time;
    private int guest_capacity;
    private String picture;
    private float price;
    private String type;
}
