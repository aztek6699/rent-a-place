package com.example.propertyservice.model;

import com.example.propertyservice.model.BookingModel;
import com.example.propertyservice.model.PropertyModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private BookingModel booking;

    @ManyToOne
    @JsonIgnore
    private PropertyModel property;
}
