package com.example.propertyservice.modules.property.model;

import com.example.propertyservice.modules.location.model.LocationModel;
import com.example.propertyservice.model.PropertyOwnerModel;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "property")
public class PropertyModel {

    @Id
    private Long property_id;

    @ManyToOne
    @JoinColumn(name="host_id")
    private PropertyOwnerModel host_id;

    @OneToOne
    @JoinColumn(name = "location_id")
    private LocationModel location_id;

    private String amenities;
    private String description;
    private Time check_in_time;
    private Time check_out_time;
    private int guest_capacity;
    private String picture;
    private float price;
    private String type;

    public PropertyModel() {

    }

    public PropertyModel(Long property_id, PropertyOwnerModel host_id, String amenities, String description, Time check_in_time, Time check_out_time, int guest_capacity, String picture, float price, String type) {
        this.property_id = property_id;
        this.host_id = host_id;
        this.amenities = amenities;
        this.description = description;
        this.check_in_time = check_in_time;
        this.check_out_time = check_out_time;
        this.guest_capacity = guest_capacity;
        this.picture = picture;
        this.price = price;
        this.type = type;
    }

    public Long getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Long property_id) {
        this.property_id = property_id;
    }

    public PropertyOwnerModel getHost_id() {
        return host_id;
    }

    public void setHost_id(PropertyOwnerModel host_id) {
        this.host_id = host_id;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getCheck_in_time() {
        return check_in_time;
    }

    public void setCheck_in_time(Time check_in_time) {
        this.check_in_time = check_in_time;
    }

    public Time getCheck_out_time() {
        return check_out_time;
    }

    public void setCheck_out_time(Time check_out_time) {
        this.check_out_time = check_out_time;
    }

    public int getGuest_capacity() {
        return guest_capacity;
    }

    public void setGuest_capacity(int guest_capacity) {
        this.guest_capacity = guest_capacity;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
