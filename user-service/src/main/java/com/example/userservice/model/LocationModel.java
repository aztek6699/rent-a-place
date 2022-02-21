package com.example.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "location")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class LocationModel {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "property_id")
    private PropertyModel property;

    @Column(unique = true)
    private String address;

    private String city;
    private String country;
}
