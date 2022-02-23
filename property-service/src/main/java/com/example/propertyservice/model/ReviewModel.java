package com.example.propertyservice.model;

import com.example.propertyservice.model.BookingModel;
import com.example.propertyservice.model.PropertyModel;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "review")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ReviewModel {

    @Id
    @Column(name = "booking_id")
    private Long id;

    private int rating;
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "booking_id")
    @JsonIgnore
    private BookingModel booking;

    @ManyToOne
    @JsonIgnore
    private PropertyModel property;
}
