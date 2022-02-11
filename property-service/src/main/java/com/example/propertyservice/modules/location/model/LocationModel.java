package com.example.propertyservice.modules.location.model;

import com.example.propertyservice.modules.property.model.PropertyModel;
import javax.persistence.*;

@Entity
@Table(name = "location")
public class LocationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long location_id;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyModel property_id;

    @Column(unique = true)
    private String address;

    private String city;
    private String country;

    public LocationModel() {

    }

    public LocationModel(Long location_id, PropertyModel property_id, String address, String city, String country) {
        this.location_id = location_id;
        this.property_id = property_id;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
    }

    public PropertyModel getProperty_id() {
        return property_id;
    }

    public void setProperty_id(PropertyModel property_id) {
        this.property_id = property_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
