package com.example.propertyservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "property_owner")
public class PropertyOwnerModel {

    @Id
    private Long host_id;

    private String password;
    private String name;
    private String mobile_number;
    private String email;
    private Date dob;

    public PropertyOwnerModel() {}

    public PropertyOwnerModel(String password, String name, String mobile_number, String email, Date dob) {
        this.password = password;
        this.name = name;
        this.mobile_number = mobile_number;
        this.email = email;
        this.dob = dob;
    }

    public PropertyOwnerModel(Long host_id, String password, String name, String mobile_number, String email, Date dob) {
        this.host_id = host_id;
        this.password = password;
        this.name = name;
        this.mobile_number = mobile_number;
        this.email = email;
        this.dob = dob;
    }

    public Long getHost_id() {
        return host_id;
    }

    public void setHost_id(Long host_id) {
        this.host_id = host_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
