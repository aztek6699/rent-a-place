package com.example.propertyservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "booking")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDate;
    private Date endDate;
    private float totalCost;

    @ManyToOne
    @JsonIgnore
    private RenterModel renter;

    @ManyToOne
    @JsonIgnore
    private PropertyModel property;

    @OneToOne(mappedBy = "booking")
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private ReviewModel review;
}
