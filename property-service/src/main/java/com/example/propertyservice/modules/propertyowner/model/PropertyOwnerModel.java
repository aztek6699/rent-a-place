package com.example.propertyservice.modules.propertyowner.model;

import com.example.propertyservice.modules.property.model.PropertyModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "property_owner")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PropertyOwnerModel {

    @Id
    private Long id;

    private String password;
    private String name;
    private String mobile_number;
    private String email;
    private Date dob;

    @OneToMany(mappedBy = "propertyOwner")
    @JsonIgnore
    private List<PropertyModel> properties;
}
