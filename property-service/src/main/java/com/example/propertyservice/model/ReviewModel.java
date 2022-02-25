package com.example.propertyservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "review")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ReviewModel implements Serializable {

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
