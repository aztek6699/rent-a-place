package com.example.propertyservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "booking")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class BookingModel implements Serializable {

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
