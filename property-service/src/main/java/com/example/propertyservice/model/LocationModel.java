package com.example.propertyservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "location")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class LocationModel implements Serializable {

    @Id
    @Column(name = "property_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "property_id")
    private PropertyModel property;

    @Column(unique = true)
    private String address;

    private String city;
    private String country;
}
