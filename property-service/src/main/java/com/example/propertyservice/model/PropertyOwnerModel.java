package com.example.propertyservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "property_owner")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PropertyOwnerModel implements Serializable {

    @Id
    private Long id;

    private String password;
    private String name;
    @Column(name = "mobile_number")
    private String mobileNumber;
    private String email;
    private Date dob;

    @OneToMany(mappedBy = "propertyOwner")
    @JsonIgnore
    private List<PropertyModel> properties;
}
