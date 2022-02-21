package com.example.propertyservice.modules.booking.model;

import com.example.propertyservice.modules.property.model.PropertyModel;
import com.example.propertyservice.modules.renter.model.RenterModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
}
