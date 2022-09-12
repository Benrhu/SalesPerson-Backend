package com.grouzy.Backend.Entities;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinitions;
import javax.persistence.*;

@Entity
@Data
public class SalesPerson extends User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "SalesPersonID")
    private Long salesPersonID;
    @Column(name="firstName")
    private String firstName;

    @Column(name="surName")
    private String surName;

    @Column(name="username")
    private String username = firstName+surName;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="postalCode")
    private String postalCode;

    @Column(name="country")
    private String country;

    public SalesPerson() {}

    public SalesPerson(String firstName, String surName, String username, String email, String phone, String address, String city, String postalCode, String country) {
        this.firstName = firstName;
        this.surName = surName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }
}
